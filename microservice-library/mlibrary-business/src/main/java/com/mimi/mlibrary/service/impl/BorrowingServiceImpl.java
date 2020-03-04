package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.account.MemberDao;
import com.mimi.mlibrary.dao.borrowing.BorrowingDao;
import com.mimi.mlibrary.dao.publication.CopyDao;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.model.source.borrowing.BorrowingStatus;
import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.service.BorrowingService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao;
    private CopyDao copyDao;
    private MemberDao memberDao;
    private BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingDao borrowingDao, BorrowingMapper borrowingMapper, CopyDao copyDao, MemberDao memberDao) {
        this.borrowingDao = borrowingDao;
        this.borrowingMapper = borrowingMapper;
        this.copyDao = copyDao;
        this.memberDao = memberDao;
    }


    @Override
    public BorrowingDto findBorrowingById( int id ) {
        Optional <Borrowing> borrowing = borrowingDao.findBorrowingById( id );
        if(borrowing.isPresent()) {
            return   borrowingMapper.map( borrowing.get() );
        }
        return null;
    }

    @Override
    public List<BorrowingDto> findAll() {
        List<Borrowing> borrowings = borrowingDao.findAll();
        List<BorrowingDto> borrowingDtos = borrowingMapper.map( borrowings );

        return borrowingDtos;
    }

    @Override
    public List<BorrowingDto> findByMemberId( int memberId ) {
        List <Borrowing> borrowings = borrowingDao.findByMemberId( memberId );
        List<BorrowingDto> borrowingDtos = borrowingMapper.map( borrowings );

        return borrowingDtos;
    }

    /**
     *
     * @param borrowing The created borrowing
     * @param memberId The id of the user who borrows a publication
     * @param copyId The id of the available copy of the publication which will be borrowed
     * @return The created borrowing
     */
    @Override
    public BorrowingDto save( Borrowing borrowing, int memberId, int copyId ) {

        // Member research
        Optional<Member> member = memberDao.getMemberById( memberId );
        int currentsBorrowings = member.get().getNbOfCurrentsBorrowings();

        // Copy research
        Copy copy = copyDao.findCopyById( copyId );
        boolean available = copy.isAvailable();

        /*
         * Member has right to borrow only 5 publications
         * To register or create a borrowing of a copy, this one should be available.
         */
        if( currentsBorrowings < 5 && available == true ) {

            LocalDate today = new LocalDate();

            copyDao.updateCopyAvailability( false, copyId );
            copyDao.updateCopyReturnDateById( today,copyId );
            memberDao.updateNbOfCurrentsBorrowings( memberId, 1);
            borrowingDao.save( borrowing );
        }



        //TODO MANAGE PB WITH RETURN WHEN CURRENTSBORROWINGS IS >=5
        return null;
    }

    @Override
    public void updateBorrowingReturnDateById( int id ) {

       //Retrieve a borrowing by its id
       /*Borrowing borrowing = borrowingDao.findBorrowingById( id );
       BorrowingDto borrowingDto = borrowingMapper.map( borrowing );

        //Retrieve the return date of this borrowing
        LocalDate returnDate = borrowingDto.getReturnDate();

       boolean extension = borrowingDto.isExtented();
       if( extension != true ) {
           //Extend the return date by 4 weeks
           returnDate = returnDate.plusDays( 28 );
           borrowingDao.updateBorrowingReturnDateById( returnDate, id );
           borrowingDao.updateExtensionById( id );

           int copyId = borrowing.getCopy().getId();
           copyDao.updateCopyReturnDateById( returnDate, copyId );
       }*/
        //TODO MESSAGE TO SIGNAL THAT THE USER HAS ALREADY EXTENDED ITS BORROWING.
    }

    @Override
    public void updateBorrowingExtensionValueById( int id ) {
        borrowingDao.updateExtensionById( id );
    }

    @Override
    public void updateBorrowingStatus( int borrowingId ) {

        Optional<Borrowing> borrowing = borrowingDao.findById( borrowingId );
        int copyId = borrowing.get().getCopy().getId();
        int memberId = borrowing.get().getMember().getId();

        copyDao.updateCopyAvailability( true, copyId );
        copyDao.updateCopyReturnDateById( null, copyId );
        memberDao.updateNbOfCurrentsBorrowings( memberId, -1 );

        borrowingDao.updateBorrowingStatus( borrowingId, BorrowingStatus.FINISHED );
    }

}
