package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.service.account.MemberService;
import com.mimi.mlibrary.service.impl.account.MemberServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    private MemberService memberService;

    MemberController(MemberServiceImpl MemberService ) {
        this.memberService = memberService;
    }

    @GetMapping( value = "/Members" )
    public List<MemberAccount> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping( value = "/Members", params = "id" )
    public Optional<MemberAccount> getMemberById( @RequestParam("id") int id ) {
        return memberService.findById( id );
    }


    @GetMapping( value = "/Members", params = "email")
    public MemberAccount getMemberByEmail ( @RequestParam("email") String email ) {
        return memberService.getMemberByEmail(email);
    }

    @GetMapping( value = "/Members", params = { "firstname", "lastname" })
    public MemberAccount getMemberByName ( @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ) {
        return memberService.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Members/add" )
    public ResponseEntity<Void> addMember( @RequestBody MemberAccount Member ) {
        MemberAccount addedMember = memberService.save( Member );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PostMapping( value = "/Member/nbBorr/{barcode}" )
    public void incrementBorrowingsNbBorrowings ( @PathVariable("barcode") String barcode ) {
        memberService.incrementNbOfCurrentsBorrowings( barcode );
    }

}

