package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.BookDao;
import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
