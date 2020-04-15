package com.mimi.mlibrary.mapper.borrowing;

import com.mimi.mlibrary.model.dto.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BorrowingMapper {

    BorrowingMapper INSTANCE = Mappers.getMapper( BorrowingMapper.class );
    BorrowingDto borToDto(Borrowing borrowing );
    List<BorrowingDto> borToDtoList( List<Borrowing> borrowings );

    Borrowing dtoToBor( BorrowingDto borrowingDto );
    List<Borrowing> dtoToBorList( List<BorrowingDto> borrowingDtos );
}
