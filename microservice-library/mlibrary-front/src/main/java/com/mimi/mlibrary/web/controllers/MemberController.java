package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.account.MemberAccount;
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
    public List<MemberAccount> getAllMembers() {
        return accountService.findAll();
    }

    @GetMapping( value = "/Members", params = "id" )
    public Optional<MemberAccount> getMemberById( @RequestParam("id") int id ) {
        return accountService.findById( id );
    }

    @GetMapping( value = "/Members", params = "email")
    public Optional<MemberAccount> getMemberByEmail ( @RequestParam("email") String email ) {
        return accountService.getMemberByEmail(email);
    }

    @GetMapping( value = "/Members", params = { "firstname", "lastname" })
    public Optional<MemberAccount> getMemberByName ( @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ) {
        return accountService.getMemberByNames( firstname, lastname );
    }

    @PostMapping( value = "/Members" )
    public ResponseEntity<Void> addMember( @RequestBody MemberAccount member ) {
        MemberAccount addedMember = accountService.save( member );
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

