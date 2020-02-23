package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.user.Member;
import com.mimi.mlibrary.model.user.User;
import com.mimi.mlibrary.service.UserService;
import com.mimi.mlibrary.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    UserController(UserServiceImpl userService ) {
        this.userService = userService;
    }

    @GetMapping( value = "/User" )
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping( value = "/User/{id}" )
    public Optional<User> getUserById(@PathVariable int id ) {
        return userService.findById( id );
    }

    @GetMapping( value = "/Member" )
    public List<Member> getAllMembers( ) {
        return userService.getAllMember();
    }

    @GetMapping( value = "/Member/{id}" )
    public Member getMemberById ( @PathVariable Integer id ) {
        return userService.getMemberById(id);
    }

    @GetMapping( value = "/Member/email/{email}" )
    public Member getMemberByEmail ( @PathVariable("email") String email ) {
        return userService.getMemberByEmail(email);
    }

    @GetMapping( value = "/Member/firstname/{firstname}/lastname/{lastname}" )
    public Member getMemberByEmail ( @PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname ) {
        return userService.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Member/add" )
    public ResponseEntity<Void> addMember( @RequestBody Member member ) {
        Member addedMember = userService.save( member );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PostMapping( value = "/Member/nbBorr/{barcode}" )
    public void incrementBorrowingsNbBorrowings ( @PathVariable("barcode") String barcode ) {
        userService.incrementNbOfCurrentsBorrowings( barcode );
    }

}

