package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dest.account.AccountDto;
import com.mimi.mlibrary.model.source.account.Account;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AccountMapperConfig {

    void mapAccount( Account mean, @MappingTarget AccountDto publicationDto );
}
