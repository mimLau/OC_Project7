package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.PublicationDao;
import com.mimi.mlibrary.model.publications.Publication;
import com.mimi.mlibrary.service.PublicationService;

import java.util.List;

public class PublicationServiceImpl implements PublicationService {
    @Override
    public Publication findByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<Publication> findAllByAuthor(String name) {
        return null;
    }

    @Override
    public List<Publication> findAllByTitle(String title) {
        return null;
    }
}
