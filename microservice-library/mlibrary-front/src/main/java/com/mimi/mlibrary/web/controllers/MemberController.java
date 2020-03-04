package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.dest.account.MemberDto;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class  MemberController {

    private AccountService accountService;

    MemberController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping( value = "/Members" )
    public List<MemberDto> getAllMembers() {
        return accountService.findAll();
    }

    @GetMapping( value = "/Members", params = "id" )
    public MemberDto getMemberById(@RequestParam("id") int id ) {
        return accountService.findById( id );
    }

    @GetMapping( value = "/Members", params = "email")
    public MemberDto getMemberByEmail (@RequestParam("email") String email ) {
        return accountService.getMemberByEmail(email);
    }

    @GetMapping( value = "/Members", params = { "firstname", "lastname" })
    public MemberDto getMemberByName (@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ) {
        return accountService.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Members" )
    public ResponseEntity<Void> addMember( @RequestBody Member member ) {
        MemberDto addedMember = accountService.save( member );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( value = "/Members" , params = "id" )
    public void incrementBorrowingsNbBorrowings ( @RequestParam("id") int id ) {
        accountService.updateNbOfCurrentsBorrowings( id );
    }

}

