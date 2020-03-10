package com.mimi.clibrary.controllers;

import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginClientController {

    private FeignProxy proxy;

    private static final String MEMBER_ATT = "user";
    private static final String MEMBER_MAIL = "mail";
    private static final String MEMBER_PASS = "PASS";

    private static final String LOGIN_VIEW = "login";


    public LoginClientController(FeignProxy proxy ) {
        this.proxy = proxy;
    }


    @RequestMapping("/")
    public String loginPage( Model model ) {
        model.addAttribute( MEMBER_ATT , new MemberBean() );
        return LOGIN_VIEW;

    }
}
