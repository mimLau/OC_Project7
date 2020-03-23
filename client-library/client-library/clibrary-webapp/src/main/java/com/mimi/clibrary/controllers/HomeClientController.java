package com.mimi.clibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeClientController {

    @RequestMapping("/")
    public String homePage( Model model ) {
        return "userHome";

    }
}
