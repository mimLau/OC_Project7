package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.service.MemberService;
import com.mimi.mlibrary.service.impl.MemberServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    private MemberService MemberService;

    MemberController(MemberServiceImpl MemberService ) {
        this.MemberService = MemberService;
    }

    @GetMapping( value = "/Member" )
    public List<MemberAccount> getAllMembers() {
        return MemberService.findAll();
    }

    @GetMapping( value = "/Member/{id}" )
    public Optional<MemberAccount> getMemberById(@PathVariable int id ) {
        return MemberService.findById( id );
    }



    @GetMapping( value = "/Member/{id}" )
    public MemberAccount getMemberById ( @PathVariable Integer id ) {
        return MemberService.getMemberById(id);
    }

    @GetMapping( value = "/Member/email/{email}" )
    public MemberAccount getMemberByEmail ( @PathVariable("email") String email ) {
        return MemberService.getMemberByEmail(email);
    }

    @GetMapping( value = "/Member/firstname/{firstname}/lastname/{lastname}" )
    public MemberAccount getMemberByEmail ( @PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname ) {
        return MemberService.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Member/add" )
    public ResponseEntity<Void> addMember( @RequestBody MemberAccount Member ) {
        MemberAccount addedMember = MemberService.save( Member );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PostMapping( value = "/Member/nbBorr/{barcode}" )
    public void incrementBorrowingsNbBorrowings ( @PathVariable("barcode") String barcode ) {
        MemberService.incrementNbOfCurrentsBorrowings( barcode );
    }

}

