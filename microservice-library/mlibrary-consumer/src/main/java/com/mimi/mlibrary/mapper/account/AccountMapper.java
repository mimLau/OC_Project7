package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dest.account.AccountDto;
import com.mimi.mlibrary.model.source.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class);
    AccountDto map( Account account );
    List<AccountDto> map( List<Account> accounts );

}
