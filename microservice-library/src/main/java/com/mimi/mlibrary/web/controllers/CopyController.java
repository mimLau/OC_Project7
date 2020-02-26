package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.service.publication.CopyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopyController {

    private CopyService copyService;


    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @GetMapping( value = "/Copies" )
    public List<Copy> getAllCopies() {
        return copyService.findAll();
    }
}
