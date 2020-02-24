package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.CopyDao;
import com.mimi.mlibrary.mapper.publication.CopyMapper;
import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import com.mimi.mlibrary.service.CopyService;
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

    @Override
    public List<CopyDto> findAll() {
        List<Copy> copies = copyDao.findAll();
        List<CopyDto> copyDtos = copyMapper.map( copies );

        return copyDtos;
    }
}
