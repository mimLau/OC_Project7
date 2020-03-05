package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.account.MemberDao;
import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.model.dest.account.MemberDto;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private MemberDao memberDao;
    private MemberMapper memberMapper;

    AccountServiceImpl( MemberDao memberDao, MemberMapper memberMapper ) {
        this.memberDao = memberDao;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDto> findAll() {
        return memberMapper.membToDtoList( memberDao.findAll() );
    }

    @Override
    public MemberDto findById( int id ) {
        return memberMapper.membToDto( memberDao.findById( id ).orElse(null) );
    }

    @Override
    public MemberDto save( Member member) {
        Member savedMember = memberDao.save( member );
        MemberDto memberDto = memberMapper.membToDto( savedMember );

        return memberDto;
    }

    @Override
    public MemberDto getMemberById( Integer id ) {
        return memberMapper.membToDto( memberDao.getMemberById( id ).orElse(null ));
    }

    @Override
    public MemberDto getMemberByEmail( String email ) {
        return memberMapper.membToDto( memberDao.getMemberByEmail( email ).orElse( null) );
    }

    @Override
    public MemberDto getMemberByNames( String firstname, String lastname ) {
        return memberMapper.membToDto( memberDao.getMemberByNames( firstname, lastname ).orElse( null) );
    }

    @Override
    public void updateNbOfCurrentsBorrowings( int id ) {
         memberDao.updateNbOfCurrentsBorrowings( id, 1);
    }
}
