package com.mimi.mlibrary.dao.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CopyMapper {

    CopyDto map( Copy copy );
    List<CopyDto> map( List<Copy> copies );
}
