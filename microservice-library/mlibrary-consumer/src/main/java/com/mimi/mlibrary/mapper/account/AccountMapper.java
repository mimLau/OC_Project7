package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dest.account.AccountDto;
import com.mimi.mlibrary.model.source.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class);
    AccountDto accToDto( Account account );
    List<AccountDto> accToDtoList( List<Account> accounts );

    /*Account dtoToAcc( AccountDto accountDto );
    List<Account> dtoToAccList( List<AccountDto> accountDtos );*/

}
