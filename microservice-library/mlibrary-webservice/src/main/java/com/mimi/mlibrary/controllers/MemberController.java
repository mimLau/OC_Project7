package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.account.MemberDto;
import com.mimi.mlibrary.service.contract.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Members")
public class  MemberController {

    private AccountService accountService;

    MemberController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping( params = { "mail", "pass"} )
    public MemberDto getMemberByMailAndPass(@RequestParam("mail") String mail, @RequestParam("pass") String pass) {
        MemberDto memberDto = accountService.findMemberByMailAndPass( mail, pass );
        if( memberDto == null ) throw new ResourceNotFoundException( "Combinaison mot de passe/email incorrecte." );

        return memberDto;
    }

    @GetMapping
    public List<MemberDto> getAllMembers() {
        return accountService.findAll();
    }

    @GetMapping( params = "id" )
    public MemberDto getMemberById(@RequestParam("id") int id ) {
        return accountService.findById( id );
    }

    @GetMapping( params = "email")
    public MemberDto getMemberByEmail (@RequestParam("email") String email ) {
        return accountService.getMemberByEmail(email);
    }

    @GetMapping( params = { "firstname", "lastname" })
    public MemberDto getMemberByName (@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ) {
        return accountService.getMemberByNames( firstname, lastname );
    }

    @PostMapping
    public ResponseEntity<Void> addMember( @RequestBody MemberDto memberDto ) {
        MemberDto addedMember = accountService.save( memberDto );
        if( addedMember == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedMember.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( params = "id" )
    public void incrementBorrowingsNbBorrowings ( @RequestParam("id") int id ) {
        accountService.updateNbOfCurrentsBorrowings( id );
    }

}

