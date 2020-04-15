package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dto.publication.AuthorDto;
import com.mimi.mlibrary.model.dto.publication.EditorDto;
import com.mimi.mlibrary.model.entity.publication.Author;
import com.mimi.mlibrary.model.entity.publication.Editor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EditorMapper {

    EditorMapper INSTANCE = Mappers.getMapper( EditorMapper.class );

    EditorDto toDto( Editor editor );
    List<EditorDto> toDtoList(List<Editor> editors );

    Editor toEntity( EditorDto editorDto );
    List<Editor> toEntityList( List<EditorDto> editorDtos );
}
