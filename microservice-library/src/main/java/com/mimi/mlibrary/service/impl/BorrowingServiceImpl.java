package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.BorrowingDao;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.BorrowingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private BorrowingDao borrowingDao;
    private BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingDao borrowingDao, BorrowingMapper borrowingMapper, BorrowingMapper borrowingMapper1) {
        this.borrowingDao = borrowingDao;
        this.borrowingMapper = borrowingMapper1;
    }

    @Override
    public List<BorrowingDto> findAll() {
        List <Borrowing> borrowings = borrowingDao.findAll();
        List <BorrowingDto> borrowingDtos = borrowingMapper.map( borrowings );
        return borrowingDtos;
    }
}
