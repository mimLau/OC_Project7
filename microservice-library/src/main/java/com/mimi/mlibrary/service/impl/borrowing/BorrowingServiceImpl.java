package com.mimi.mlibrary.service.impl.borrowing;

import com.mimi.mlibrary.dao.borrowing.BorrowingDao;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.borrowing.BorrowingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao;
    //private BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingDao borrowingDao, BorrowingMapper borrowingMapper, BorrowingMapper borrowingMapper1) {
        this.borrowingDao = borrowingDao;
        //this.borrowingMapper = borrowingMapper1;
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




    /*@Override
    public List<BorrowingDto> findAll() {
        List <Borrowing> borrowings = borrowingDao.findAll();
        List <BorrowingDto> borrowingDtos = borrowingMapper.map( borrowings );
        return borrowingDtos;
    }*/
}
