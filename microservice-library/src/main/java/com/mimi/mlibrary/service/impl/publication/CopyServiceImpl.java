package com.mimi.mlibrary.service.impl.publication;

import com.mimi.mlibrary.dao.publication.CopyDao;
import com.mimi.mlibrary.mapper.publication.CopyMapper;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.service.publication.CopyService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyServiceImpl implements CopyService {

    private CopyDao copyDao;
    private CopyMapper copyMapper;

    public CopyServiceImpl(CopyDao copyDao, CopyMapper copyMapper) {
        this.copyDao = copyDao;
        this.copyMapper = copyMapper;
    }

    public List<Copy> findAll() {
        return copyDao.findAll();
    }

    @Override
    public List<Copy> findAllByBookId(int bookId ) {
        return copyDao.findAllByBookId( bookId );
    }

    @Override
    public List<Copy> findAllByReviewId( int reviewId ) {
        return copyDao.findAllByBookId( reviewId );
    }

    @Override
    public List<Copy> findAllByNewspaperId( int newspaperId ) {
        return copyDao.findAllByBookId( newspaperId );
    }

    @Override
    public List<Copy> findAllByDelay( ) {
        LocalDate localDate = new LocalDate();

        return copyDao.findAllByDelay( localDate );
    }



   /* @Override
    public List<CopyDto> findAll() {
        List<Copy> copies = copyDao.findAll();
        List<CopyDto> copyDtos = copyMapper.map( copies );

        return copyDtos;
    }*/
}
