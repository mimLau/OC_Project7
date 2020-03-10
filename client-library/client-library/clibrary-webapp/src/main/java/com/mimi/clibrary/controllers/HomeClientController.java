package com.mimi.clibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeClientController {

    @RequestMapping("/")
    public String homePage( Model model ) {
        return "home";

    }
}
