package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dto.publication.LibraryDto;
import com.mimi.mlibrary.model.entity.publication.Library;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LibraryMapper {

    LibraryMapper INSTANCE = Mappers.getMapper( LibraryMapper.class );

    LibraryDto toDto(Library library );
    List<LibraryDto> toDtoList(List<Library> libraries );

    Library toEntity( LibraryDto libraryDto );
    List<Library> toEntityList( List<LibraryDto> libraryDtos );
}
