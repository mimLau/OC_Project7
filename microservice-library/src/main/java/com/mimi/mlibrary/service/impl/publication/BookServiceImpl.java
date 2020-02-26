package com.mimi.mlibrary.service.impl.publication;

import com.mimi.mlibrary.dao.BookDao;
import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.service.publication.BookService;
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

    @Override
    public List<Book> findAllByAuthor( String name ) {
        return bookDao.findAllByAuthor( name );
    }

    @Override
    public List<Book> findAllByTitle( String title ) {
        return bookDao.findAllByTitle( title );
    }
}
