package com.mimi.mlibrary.service.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import org.joda.time.LocalDate;

import java.util.List;

public interface CopyService {

    //List<CopyDto> findAll();

    List<Copy> findAll();
    List<Copy> findAllByBookId( int id );
    List<Copy> findAllByReviewId( int id );
    List<Copy> findAllByNewspaperId( int id );
    List<Copy> findAllByDelay( );
}
