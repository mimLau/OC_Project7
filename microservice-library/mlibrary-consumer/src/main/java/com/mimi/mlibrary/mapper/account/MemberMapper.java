package com.mimi.mlibrary.mapper.account;


import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.model.dest.account.MemberDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( config = MemberMapperConfig.class )
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper( MemberMapper.class );

    @InheritConfiguration( name = "mapMember")
    MemberDto toDto( Member member );
    List<MemberDto> toDtoList( List<Member> members );

    Member toEntity( MemberDto memberDto );
    List<Member> toEntityList( List<MemberDto> memberDtos );

}
