package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;

import java.util.List;

public interface BorrowingService {

    List<BorrowingDto> findAll();
}
