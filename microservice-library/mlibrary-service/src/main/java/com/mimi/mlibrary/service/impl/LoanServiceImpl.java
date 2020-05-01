package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.mapper.loan.LoanMapper;
import com.mimi.mlibrary.mapper.publication.CopyMapper;
import com.mimi.mlibrary.model.dto.account.MemberDto;
import com.mimi.mlibrary.model.dto.loan.LoanDto;
import com.mimi.mlibrary.model.dto.publication.CopyDto;
import com.mimi.mlibrary.model.entity.loan.Loan;
import com.mimi.mlibrary.model.entity.loan.LoanStatus;
import com.mimi.mlibrary.repository.account.MemberRepository;
import com.mimi.mlibrary.repository.loan.LoanRepository;
import com.mimi.mlibrary.repository.publication.CopyRepository;
import com.mimi.mlibrary.repository.publication.PublicationRepository;
import com.mimi.mlibrary.service.contract.LoanService;
import com.mimi.mlibrary.service.exceptions.BadRequestException;
import com.mimi.mlibrary.service.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private CopyRepository copyRepository;
    private MemberRepository memberRepository;
    private PublicationRepository publicationRepository;

    public LoanServiceImpl(LoanRepository loanRepository, CopyRepository copyRepository, MemberRepository memberRepository, PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
        this.loanRepository = loanRepository;
        this.copyRepository = copyRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public LoanDto findLoanById( int id ) {
        return   LoanMapper.INSTANCE.toDto( loanRepository.findLoanById( id ).orElse(null));
    }

    @Override
    public List<LoanDto> findAll() {
        return LoanMapper.INSTANCE.toDtoList( loanRepository.findAllLoans( LoanStatus.INPROGRESS));
    }

    @Override
    public List<LoanDto> findByMemberId( int memberId ) {
        return LoanMapper.INSTANCE.toDtoList( loanRepository.findByMemberId( memberId, LoanStatus.INPROGRESS) );
    }

    /**
     *

     * @param memberId The id of the user who borrows a publication
     * @param copyId The id of the available copy of the publication which will be borrowed
     * @return The created Loan
     */
    @Override
    public LoanDto save( int memberId, int copyId ) {

        int currentsLoans;
        boolean available;
        int publicationId;

        // Copy research
        CopyDto copyDto = CopyMapper.INSTANCE.toDto( copyRepository.findCopyById( copyId ).orElse(null));
        // Member research
        MemberDto memberDto = MemberMapper.INSTANCE.toDto( memberRepository.getMemberById( memberId ).orElse(null));


        if( copyDto == null && memberDto == null )
            throw new ResourceNotFoundException("L'utilisateur et la copie demandés n'existent pas.");
        else if( copyDto == null )
            throw new ResourceNotFoundException("La copie demandée n'existe pas.");
        else if( memberDto == null )
            throw new ResourceNotFoundException("L'utilisateur demandé n'existe pas.");
        else {

            currentsLoans = memberDto.getNbOfCurrentsLoans();
            available = copyDto.isAvailable();
            // Retrieve publication id from copy to update publication av nbOfAvailableCopies attribute.
            publicationId = copyDto.getPublication().getId();
        }

        /*
         * Member has right to borrow only 5 publications
         * To register or create a Loan of a copy, this one should be available.
         */
        if( currentsLoans < 5 && available == true ) {

            LocalDate today = LocalDate.now();

            copyRepository.updateCopyAvailability( false, copyId );
            copyRepository.updateCopyReturnDateById( today.plusDays( 28 ),copyId );
            memberRepository.updateNbOfCurrentsLoans( memberId, 1);
            publicationRepository.updateNbOfAvailableCopies( publicationId, -1 );


            //Set attributes to the created loan.

            LoanDto loanDto = new LoanDto();

            loanDto.setCopy( CopyMapper.INSTANCE.toEntity( copyDto ));
            loanDto.setMember( MemberMapper.INSTANCE.toEntity( memberDto ));
            loanDto.setReturnDate( today.plusDays( 28 ) );
            loanDto.setLoanDate( today );
            loanDto.setExtented( false );
            loanDto.setLoanStatus( "INPROGRESS" );
            loanDto.setReminderNb( 0 );

            Optional.of( LoanMapper.INSTANCE.toEntity( loanDto ) ).ifPresent( loan -> loanRepository.save( loan ));
            return loanDto;

        } else if( currentsLoans == 5 && available == false) {
            throw new BadRequestException("User has already 5 loans and copie isn't available.");

        } else if( currentsLoans == 5 ) {
            throw new BadRequestException("User has already 5 loans.");
        }
        else if( available == false ) {
             throw new BadRequestException("This copy isn't available.");
        }

        return null;
    }

    @Override
    public void extendLoanReturnDateById( int LoanId ) {

       //Retrieve a Loan by its id
        LoanDto LoanDto = LoanMapper.INSTANCE.toDto( loanRepository.findLoanById( LoanId ).orElse(null));

        //Retrieve the return date of this Loan
        LocalDate returnDate = LoanDto.getReturnDate();

       boolean extension = LoanDto.isExtented();
       if( extension != true ) {
           //Extend the return date by 4 weeks
           returnDate = returnDate.plusDays( 28 );
           loanRepository.updateLoanReturnDateById( returnDate, LoanId );
           loanRepository.updateExtensionById( LoanId );

           int copyId = LoanDto.getCopy().getId();
           copyRepository.updateCopyReturnDateById( returnDate, copyId );
       }
        //TODO MESSAGE TO SIGNAL THAT THE USER HAS ALREADY EXTENDED ITS Loan.
    }

    @Override
    public void updateLoanStatus( int loanId ) {

        Optional<Loan> loan = loanRepository.findById( loanId );
        int copyId = loan.get().getCopy().getId();
        int memberId = loan.get().getMember().getId();

        copyRepository.updateCopyAvailability( true, copyId );
        copyRepository.updateCopyReturnDateById( null, copyId );
        memberRepository.updateNbOfCurrentsLoans( memberId, -1 );

        loanRepository.updateLoanStatus( loanId, LoanStatus.FINISHED );
    }


    @Override
    public void updateReminderNbById( int loanId ) {
        loanRepository.updateReminderNbById( loanId );
    }

    @Override
    public List<LoanDto> findByDelay() {
        LocalDate currentDate = LocalDate.now();
        return  LoanMapper.INSTANCE.toDtoList( loanRepository.findByDelay( currentDate , LoanStatus.INPROGRESS ) );

    }

    @Override
    public Map<String, LocalDate> findOutdatedLoansEmailMember() {

        List <LoanDto>  loanDtos = this.findByDelay();
        Map<String, LocalDate> emailsAndReturnDates = new HashMap<>();

        for( LoanDto loan : loanDtos )
            emailsAndReturnDates.put(loan.getMember().getAccountOwnerEmail(), loan.getReturnDate() );

        return emailsAndReturnDates;
    }
}
