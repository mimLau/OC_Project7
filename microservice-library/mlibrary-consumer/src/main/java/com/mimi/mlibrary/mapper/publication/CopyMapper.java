package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CopyMapper {

    CopyDto copyToDto( Copy copy );
    List<CopyDto> copyTodtoList( List<Copy> copies );

    Copy dtoToCopy( CopyDto copyDto );
    List<Copy> dtoToCopyList( List<CopyDto> copyDtos );
}
