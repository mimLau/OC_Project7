package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;
import com.mimi.mlibrary.model.dto.publication.PublicationDto;
import com.mimi.mlibrary.model.entity.publication.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

//@Mapper(uses = {SubCategoryMapper.class})
@Mapper
public interface PublicationMapper {

    // By convention, a mapper interface should define a member called INSTANCE
    // which holds a single instance of the mapper type:
    PublicationMapper INSTANCE = Mappers.getMapper( PublicationMapper.class );

    @Mapping(target="subCategoryStr", source="subCategory", qualifiedBy = SubCategoryMapper.class)
    PublicationDto toDto( Publication publication );
    List <PublicationDto> toDtoList( List<Publication> publications );

    Publication toEntity( PublicationDto publicationDto );
    List<Publication> toListEntity( List<PublicationDto> publicationDtos );

    //private String subCategoryStr;
    @SubCategoryMapper
    static String toSubStr( SubCategory subCategory ) {
        return subCategory.getFrName();

    }

}
