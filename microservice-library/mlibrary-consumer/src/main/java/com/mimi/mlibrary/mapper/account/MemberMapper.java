package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dest.account.MemberDto;
import com.mimi.mlibrary.model.source.account.Member;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = MemberMapperConfig.class )
public interface MemberMapper {

    @InheritConfiguration( name = "mapMember")
    MemberDto map( Member member );
    List<MemberDto> map( List<Member> members );

}
