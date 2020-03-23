package com.mimi.clibrary.controllers;

import feign.FeignException;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("memberSession")
public class LoginClientController {

    private FeignProxy proxy;

    private static final String MEMBER_ATT = "member";
    private static final String MEMBER_MAIL = "mail";
    private static final String MEMBER_PASS = "PASS";
    private static final String ERROR_MESS = "* Combinaison Email/mot de passe incorrecte.";

    private static final String LOGIN_VIEW = "login";
    private static final String USER_HOME_VIEW = "redirect:/user/home";


    public LoginClientController(FeignProxy proxy ) {
        this.proxy = proxy;
    }


    @GetMapping("/login")
    public String showLoginForm( Model model ) {
        model.addAttribute( MEMBER_ATT , new MemberBean() );
        return LOGIN_VIEW;

    }

    @PostMapping("/login")
    public String checkMemberCred(@ModelAttribute( MEMBER_ATT ) MemberBean member, BindingResult result, Model model ) {

        try {

            MemberBean memberB = proxy.getMemberByMailAndPass( member.getAccountOwnerEmail(), member.getAccountOwnerPass() );
            //model.addAttribute( "memberSession", memberB );
            model.addAttribute( "memberSession", "fffff" );

            return  USER_HOME_VIEW;
        }
        catch ( FeignException feign ) {

            //result.addError( new FieldError( MEMBER_ATT, MEMBER_MAIL, ERROR_MESS ));
            model.addAttribute("errorMessage", ERROR_MESS);
            return LOGIN_VIEW;
        }

    }
}
