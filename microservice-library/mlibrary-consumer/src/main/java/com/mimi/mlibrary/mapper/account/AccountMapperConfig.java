package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dto.account.AccountDto;
import com.mimi.mlibrary.model.entity.account.Account;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AccountMapperConfig {

    void mapAccount( Account mean, @MappingTarget AccountDto publicationDto );
}
