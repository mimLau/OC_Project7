package com.mimi.clibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("memberSession")
public class UserHomeClientController {

    private static final String USER_HOME_VIEW = "userHome";
    private static final String MEMBER_ATT = "member";


    @GetMapping("/user/home")
    public String homePage( Model model, SessionStatus status, HttpServletRequest httpRequest ) {
       //model.addAttribute( );

        return USER_HOME_VIEW;

    }
}
