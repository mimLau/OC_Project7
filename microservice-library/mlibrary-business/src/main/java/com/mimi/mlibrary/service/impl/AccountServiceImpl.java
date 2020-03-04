package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.account.MemberDao;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private MemberDao memberDao;

    AccountServiceImpl(MemberDao memberDao ) {
        this.memberDao = memberDao;
    }

    public List<Member> findAll() {
        return memberDao.findAll();
    }

    public Optional<Member> findById(int id ) {
        return memberDao.findById( id );
    }

    public Member save(Member member) {
        return memberDao.save( member );
    }

    @Override
    public Optional<Member> getMemberById(Integer id ) {
        return memberDao.getMemberById( id );
    }

    @Override
    public Optional<Member> getMemberByEmail(String email ) {
        return memberDao.getMemberByEmail( email );
    }

    @Override
    public Optional<Member> getMemberByNames(String firstname, String lastname ) {
        return memberDao.getMemberByNames( firstname, lastname );
    }

    @Override
    public void updateNbOfCurrentsBorrowings( int id ) {
         memberDao.updateNbOfCurrentsBorrowings( id, 1);
    }
}
