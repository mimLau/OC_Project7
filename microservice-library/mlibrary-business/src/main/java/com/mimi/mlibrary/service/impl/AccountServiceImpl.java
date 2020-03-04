package com.mimi.mlibrary.service.impl;

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
    private MemberMapper memberMapper;

    AccountServiceImpl( MemberDao memberDao, MemberMapper memberMapper ) {
        this.memberDao = memberDao;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDto> findAll() {
        List<Member> members =  memberDao.findAll();
        List<MemberDto> memberDtos = memberMapper.map( members );

        return memberDtos;
    }

    @Override
    public MemberDto findById( int id ) {
        Optional<Member> member = memberDao.findById( id );
        MemberDto memberDto = memberMapper.map( member.get() );

        return memberDto;
    }

    @Override
    public MemberDto save( Member member) {
        Member savedMember = memberDao.save( member );
        MemberDto memberDto = memberMapper.map( savedMember );

        return memberDto;
    }

    @Override
    public MemberDto getMemberById( Integer id ) {
        Optional<Member> member = memberDao.getMemberById( id );
        MemberDto memberDto = memberMapper.map( member.get() );
        return memberDto;
    }

    @Override
    public MemberDto getMemberByEmail( String email ) {
        Optional<Member> member = memberDao.getMemberByEmail( email );
        MemberDto memberDto = memberMapper.map( member.get() );

        return memberDto;
    }

    @Override
    public MemberDto getMemberByNames( String firstname, String lastname ) {
        Optional<Member> member = memberDao.getMemberByNames( firstname, lastname );
        MemberDto memberDto = memberMapper.map( member.get() );

        return memberDto;
    }

    @Override
    public void updateNbOfCurrentsBorrowings( int id ) {
         memberDao.updateNbOfCurrentsBorrowings( id, 1);
    }
}
