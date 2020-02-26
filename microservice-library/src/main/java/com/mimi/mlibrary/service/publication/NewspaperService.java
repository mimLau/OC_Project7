package com.mimi.mlibrary.service.publication;

import com.mimi.mlibrary.model.source.publication.Newspaper;

import java.util.List;

public interface NewspaperService {

    List<Newspaper> findAllByName( String name );
}
