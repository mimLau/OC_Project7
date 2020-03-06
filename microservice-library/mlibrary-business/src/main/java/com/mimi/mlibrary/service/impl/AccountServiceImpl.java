package com.mimi.mlibrary.service.impl;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.mimi.mlibrary.dao.account.MemberDao;
import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.model.dest.account.MemberDto;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private MemberDao memberDao;

    AccountServiceImpl( MemberDao memberDao ) {
        this.memberDao = memberDao;
    }

    @Override
    public List<MemberDto> findAll() {
        return MemberMapper.INSTANCE.toDtoList( memberDao.findAll() );
    }

    @Override
    public MemberDto findById( int id ) {
        return MemberMapper.INSTANCE.toDto( memberDao.findById( id ).orElse(null) );
    }

    @Override
    public MemberDto save( MemberDto memberDto ) {
        //TODO Verify if member already exists
        Optional.of( MemberMapper.INSTANCE.toEntity( memberDto ) ).ifPresent( member -> memberDao.save( member ));

        return memberDto;
    }

    @Override
    public MemberDto getMemberById( Integer id ) {
        return MemberMapper.INSTANCE.toDto( memberDao.getMemberById( id ).orElse(null ));
    }

    @Override
    public MemberDto getMemberByEmail( String email ) {
        return MemberMapper.INSTANCE.toDto( memberDao.getMemberByEmail( email ).orElse( null) );
    }

    @Override
    public MemberDto getMemberByNames( String firstname, String lastname ) {
        return MemberMapper.INSTANCE.toDto( memberDao.getMemberByNames( firstname, lastname ).orElse( null) );
    }

    @Override
    public void updateNbOfCurrentsBorrowings( int id ) {
         memberDao.updateNbOfCurrentsBorrowings( id, 1);
    }
}
