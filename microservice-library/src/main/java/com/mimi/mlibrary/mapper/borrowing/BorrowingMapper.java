package com.mimi.mlibrary.mapper.borrowing;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BorrowingMapper {

    BorrowingMapper INSTANCE = Mappers.getMapper( BorrowingMapper.class );
    BorrowingDto map(Borrowing borrowing );
    List<BorrowingDto> map( List<Borrowing> borrowings );
}
