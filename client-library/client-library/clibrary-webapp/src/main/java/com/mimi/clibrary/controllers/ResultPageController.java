package com.mimi.clibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultPageController {

    private static final String PUBLICATION_VIEW = "publicationResult";



    @GetMapping("/Publication/result")
    public String homePage( Model model ) {

        return PUBLICATION_VIEW;

    }
}
