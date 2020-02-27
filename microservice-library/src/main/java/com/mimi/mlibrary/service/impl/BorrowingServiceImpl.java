package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.borrowing.BorrowingDao;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.BorrowingService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao;
    //private BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingDao borrowingDao, BorrowingMapper borrowingMapper, BorrowingMapper borrowingMapper1) {
        this.borrowingDao = borrowingDao;
        //this.borrowingMapper = borrowingMapper1;
    }


    @Override
    public Borrowing findBorrowingById( int id ) {
        return borrowingDao.findBorrowingById( id );
    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingDao.findAll();
    }

    @Override
    public List<Borrowing> findByMemberId(int memberId) {
        return borrowingDao.findByMemberId( memberId );
    }

    @Override
    public Borrowing save( Borrowing borrowing ) {
        return borrowingDao.save( borrowing );
    }

    @Override
    public void updateBorrowingReturnDateById( int extendedDay, int id ) {

       //Retrieve a borrowing by its id
       Borrowing borrowing = borrowingDao.findBorrowingById( id );

       //Retrieve the return date of this borrowing
       LocalDate returnDate = borrowing.getReturnDate();

       //Extend the return date by 4 weeks
       returnDate = returnDate.plusDays( extendedDay );

       borrowingDao.updateBorrowingReturnDateById( returnDate, id );
    }




    /*@Override
    public List<BorrowingDto> findAll() {
        List <Borrowing> borrowings = borrowingDao.findAll();
        List <BorrowingDto> borrowingDtos = borrowingMapper.map( borrowings );
        return borrowingDtos;
    }*/
}
