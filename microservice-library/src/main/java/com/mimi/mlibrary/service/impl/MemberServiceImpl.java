package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.MemberDao;
import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberDao MemberDao;

    MemberServiceImpl( MemberDao MemberDao ) {
        this.MemberDao = MemberDao;
    }

    public List<MemberAccount> findAll() {
        return MemberDao.findAll();
    }

    public Optional<MemberAccount> findById( int id ) {
        return MemberDao.findById( id );
    }

    public MemberAccount save(MemberAccount Member) {
        return MemberDao.save( Member );
    }

    @Override
    public MemberAccount getMemberById( Integer id ) {
        return MemberDao.getMemberById( id );
    }

    @Override
    public MemberAccount getMemberByEmail( String email ) {
        return MemberDao.getMemberByEmail( email );
    }

    @Override
    public MemberAccount getMemberByNames( String firstname, String lastname ) {
        return MemberDao.getMemberByNames( firstname, lastname );
    }

    @Override
    public void incrementNbOfCurrentsBorrowings( String barcode ) {
         MemberDao.incrementNbOfCurrentsBorrowings( barcode );
    }
}
