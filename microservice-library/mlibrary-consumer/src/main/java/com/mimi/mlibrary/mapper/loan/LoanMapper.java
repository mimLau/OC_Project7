package com.mimi.mlibrary.mapper.loan;

import com.mimi.mlibrary.model.dto.loan.LoanDto;
import com.mimi.mlibrary.model.entity.loan.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper( LoanMapper.class );
    LoanDto toDto(Loan loan );
    List<LoanDto> toDtoList( List<Loan> loans );

    Loan toEntity( LoanDto loanDto );
    List<Loan> toEntityList( List<LoanDto> loanDtos );
}
