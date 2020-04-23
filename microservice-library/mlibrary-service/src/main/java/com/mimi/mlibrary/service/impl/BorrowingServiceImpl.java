package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.repository.account.MemberRepository;
import com.mimi.mlibrary.repository.borrowing.BorrowingRepository;
import com.mimi.mlibrary.repository.publication.CopyRepository;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.dto.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import com.mimi.mlibrary.model.entity.borrowing.BorrowingStatus;
import com.mimi.mlibrary.model.entity.publication.Copy;
import com.mimi.mlibrary.service.contract.BorrowingService;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    final static Logger logger  = LogManager.getLogger(Borrowing.class);

    private BorrowingRepository borrowingRepository;
    private CopyRepository copyRepository;
    private MemberRepository memberRepository;
    private BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository, BorrowingMapper borrowingMapper, CopyRepository copyRepository, MemberRepository memberRepository) {
        this.borrowingRepository = borrowingRepository;
        this.borrowingMapper = borrowingMapper;
        this.copyRepository = copyRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public BorrowingDto findBorrowingById( int id ) {
        return   borrowingMapper.borToDto( borrowingRepository.findBorrowingById( id ).orElse(null));
    }

    @Override
    public List<BorrowingDto> findAll() {
        return borrowingMapper.borToDtoList( borrowingRepository.findAllBorrowings( BorrowingStatus.INPROGRESS));
    }

    @Override
    public List<BorrowingDto> findByMemberId( int memberId ) {
        return borrowingMapper.borToDtoList( borrowingRepository.findByMemberId( memberId, BorrowingStatus.INPROGRESS) );
    }

    /**
     *

     * @param memberId The id of the user who borrows a publication
     * @param copyId The id of the available copy of the publication which will be borrowed
     * @return The created borrowing
     */
    @Override
    public BorrowingDto save( int memberId, int copyId ) {

        // Member research
        Optional<Member> member = memberRepository.getMemberById( memberId );
        int currentsBorrowings = member.get().getNbOfCurrentsBorrowings();

        // Copy research
        Optional <Copy> copy = copyRepository.findCopyById( copyId );
        boolean available = copy.get().isAvailable();

        /*
         * Member has right to borrow only 5 publications
         * To register or create a borrowing of a copy, this one should be available.
         */
        if( currentsBorrowings < 5 && available == true ) {

            LocalDate today = LocalDate.now();

            copyRepository.updateCopyAvailability( false, copyId );
            copyRepository.updateCopyReturnDateById( today.plusDays( 28 ),copyId );
            memberRepository.updateNbOfCurrentsBorrowings( memberId, 1);


            //Set attributes to the created borrowing.

            BorrowingDto borrowingDto = new BorrowingDto();

            borrowingDto.setCopy( copy.get() );
            borrowingDto.setMember( member.get() );
            borrowingDto.setReturnDate( today.plusDays( 28 ) );
            borrowingDto.setBorrowingDate( today );
            borrowingDto.setExtented( false );
            borrowingDto.setBorrowingStatus( "INPROGRESS" );
            borrowingDto.setReminderNb( 0 );

            Optional.of( BorrowingMapper.INSTANCE.dtoToBor( borrowingDto ) ).ifPresent( borrowing -> borrowingRepository.save( borrowing ));
            return borrowingDto;
        }

        logger.info(" L'exemplaire sélectionné n'est pas disponible et/ou l'utilisateur a 5 livres à son actif:\n"
                        + "Id utilisateur: " + member.get().getId() + "\n"
                        + "Nombre de livres empruntés: " + currentsBorrowings + "\n"
                        + "Publication disponible?: " + available + "\n");

        return null;
    }

    @Override
    public void extendBorrowingReturnDateById( int borrowingId ) {

       //Retrieve a borrowing by its id
        BorrowingDto borrowingDto = borrowingMapper.borToDto( borrowingRepository.findBorrowingById( borrowingId ).orElse(null));

        //Retrieve the return date of this borrowing
        LocalDate returnDate = borrowingDto.getReturnDate();

       boolean extension = borrowingDto.isExtented();
       if( extension != true ) {
           //Extend the return date by 4 weeks
           returnDate = returnDate.plusDays( 28 );
           borrowingRepository.updateBorrowingReturnDateById( returnDate, borrowingId );
           borrowingRepository.updateExtensionById( borrowingId );

           int copyId = borrowingDto.getCopy().getId();
           copyRepository.updateCopyReturnDateById( returnDate, copyId );
       }
        //TODO MESSAGE TO SIGNAL THAT THE USER HAS ALREADY EXTENDED ITS BORROWING.
    }

    /*@Override
    public void updateBorrowingExtensionValueById( int id ) {
        borrowingRepository.updateExtensionById( id );
    }*/

    @Override
    public void updateBorrowingStatus( int borrowingId ) {

        Optional<Borrowing> borrowing = borrowingRepository.findById( borrowingId );
        int copyId = borrowing.get().getCopy().getId();
        int memberId = borrowing.get().getMember().getId();

        copyRepository.updateCopyAvailability( true, copyId );
        copyRepository.updateCopyReturnDateById( null, copyId );
        memberRepository.updateNbOfCurrentsBorrowings( memberId, -1 );

        borrowingRepository.updateBorrowingStatus( borrowingId, BorrowingStatus.FINISHED );
    }

    @Override
    public List<BorrowingDto> findByDelay() {
        LocalDate currentDate = LocalDate.now();
        return  BorrowingMapper.INSTANCE.borToDtoList( borrowingRepository.findByDelay( currentDate , BorrowingStatus.INPROGRESS ) );

    }

    @Override
    public Map<String, LocalDate> findOutdatedBorrowingsEmailMember() {

        List <BorrowingDto>  borrowingDtos = this.findByDelay();
        Map<String, LocalDate> emailsAndReturnDates = new HashMap<>();

        for( BorrowingDto borrowing : borrowingDtos )
            emailsAndReturnDates.put(borrowing.getMember().getAccountOwnerEmail(), borrowing.getReturnDate() );

        return emailsAndReturnDates;
    }
}
