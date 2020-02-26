package com.mimi.mlibrary.service.impl.publication;

import com.mimi.mlibrary.dao.publication.NewspaperDao;
import com.mimi.mlibrary.model.source.publication.Newspaper;
import com.mimi.mlibrary.service.publication.NewspaperService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperServiceImpl implements NewspaperService {

    private NewspaperDao newspaperDao;

    public NewspaperServiceImpl(NewspaperDao newspaperDao) {
        this.newspaperDao = newspaperDao;
    }

    @Override
    public List<Newspaper> findAllByName(String name) {
        return newspaperDao.findAllByName( name );
    }
}
