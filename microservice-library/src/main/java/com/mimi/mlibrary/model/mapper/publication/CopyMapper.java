package com.mimi.mlibrary.model.mapper.publication;

import com.mimi.mlibrary.model.publication.Copy;
import com.mimi.mlibrary.model.publication.CopyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CopyMapper {

    CopyDto map( Copy copy );
    List<CopyDto> map( List<Copy> copies );
}
