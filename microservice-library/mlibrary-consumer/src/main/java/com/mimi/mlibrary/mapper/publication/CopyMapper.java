package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CopyMapper {

    CopyMapper INSTANCE = Mappers.getMapper( CopyMapper.class );

    CopyDto toDto( Copy copy );
    List<CopyDto> toDtoList( List<Copy> copies );

    Copy toEntity( CopyDto copyDto );
    List<Copy> toEntityList( List<CopyDto> copyDtos );
}
