package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.account.MemberDao;
import com.mimi.mlibrary.model.source.account.MemberAccount;
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

    public List<MemberAccount> findAll() {
        return memberDao.findAll();
    }

    public Optional<MemberAccount> findById( int id ) {
        return memberDao.findById( id );
    }

    public MemberAccount save(MemberAccount member) {
        return memberDao.save( member );
    }

    @Override
    public Optional<MemberAccount> getMemberById( Integer id ) {
        return memberDao.getMemberById( id );
    }

    @Override
    public Optional<MemberAccount> getMemberByEmail( String email ) {
        return memberDao.getMemberByEmail( email );
    }

    @Override
    public Optional<MemberAccount> getMemberByNames( String firstname, String lastname ) {
        return memberDao.getMemberByNames( firstname, lastname );
    }

    @Override
    public void incrementNbOfCurrentsBorrowings( String barcode ) {
         memberDao.incrementNbOfCurrentsBorrowings( barcode );
    }
}
