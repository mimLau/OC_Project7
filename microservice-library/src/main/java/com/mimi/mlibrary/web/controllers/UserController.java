package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.dao.UserDao;
import com.mimi.mlibrary.model.users.Member;
import com.mimi.mlibrary.model.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserDao userDao;

    UserController( UserDao userDao ) {
        this.userDao= userDao;
    }

    @GetMapping( value = "/User" )
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping( value = "/User/{id}" )
    public Optional<User> getUserById( @PathVariable int id ) {
        return userDao.findById(id);
    }

    @GetMapping( value = "/Member" )
    public List<Member> getAllMembers( ) {
        return userDao.getAllMembers();
    }

    @GetMapping( value = "/Member/{id}" )
    public Member getMemberById ( @PathVariable Integer id ) {
        return userDao.getMemberById(id);
    }

    @GetMapping( value = "/Member/email/{email}" )
    public Member getMemberByEmail ( @PathVariable("email") String email ) {
        return userDao.getMemberByEmail(email);
    }

    @GetMapping( value = "/Member/firstname/{firstname}/lastname/{lastname}" )
    public Member getMemberByEmail ( @PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname ) {
        return userDao.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Member/add" )
    public ResponseEntity<Void> addMember( @RequestBody Member member ) {
        Member addedMember = userDao.save( member );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PostMapping( value = "/Member/nbBorr/{barcode}" )
    public void incrementBorrowingsNbBorrowings ( @PathVariable("barcode") String barcode ) {
         userDao.incrementNbOfCurrentsBorrowings( barcode );
    }

}

