package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.UserDao;
import com.mimi.mlibrary.model.users.Member;
import com.mimi.mlibrary.model.users.User;
import com.mimi.mlibrary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public Optional<User> findById(int id) {
        return userDao.findById( id );
    }

    public Member save(Member member) {
        return userDao.save( member );
    }

    @Override
    public List<Member> getAllMember() {
        return userDao.getAllMember();
    }

    @Override
    public Member getMemberById(Integer id) {
        return userDao.getMemberById( id );
    }

    @Override
    public Member getMemberByEmail(String email) {
        return userDao.getMemberByEmail( email );
    }

    @Override
    public Member getMemberByNames(String firstname, String lastname) {
        return userDao.getMemberByNames( firstname, lastname );
    }

    @Override
    public void incrementNbOfCurrentsBorrowings(String barcode) {
         userDao.incrementNbOfCurrentsBorrowings( barcode );
    }
}
