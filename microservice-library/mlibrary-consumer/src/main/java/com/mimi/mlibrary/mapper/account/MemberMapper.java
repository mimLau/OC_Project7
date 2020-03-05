package com.mimi.mlibrary.mapper.account;


import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.model.dest.account.MemberDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = MemberMapperConfig.class )
public interface MemberMapper {

    @InheritConfiguration( name = "mapMember")
    MemberDto membToDto( Member member );
    List<MemberDto> membToDtoList( List<Member> members );

    /*Member dtoToMemb( MemberDto memberDto );
    List<Member> dtoToMembList( List<MemberDto> memberDtos );*/

}
