package com.mimi.clibrary.controllers;

import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mimi.clibrary.Beans.account.EmployeeBean;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.account.UserBean;
import org.mimi.clibrary.proxies.AuthFeignProxy;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("memberSession")
public class LoginLogoutClientController {

    final static Logger LOGGER  = LogManager.getLogger(LoginLogoutClientController.class);
    private FeignProxy proxy;
    private AuthFeignProxy authProxy;

    private static final String USER_ATT = "user";
    private static final String MEMBER_MAIL = "mail";
    private static final String MEMBER_PASS = "PASS";
    private static final String ERROR_MESS = "* Combinaison Email/mot de passe incorrecte.";

    private static final String LOGIN_VIEW = "login";
    private static final String LOGIN_PAGE = "redirect:/Login";
    private static final String USER_HOME_PAGE = "redirect:/User/home";

    public LoginLogoutClientController(FeignProxy proxy, AuthFeignProxy authProxy) {
        this.proxy = proxy;
        this.authProxy = authProxy;
    }

    @GetMapping("/Login")
    public String showLoginForm( Model model  ) {
        model.addAttribute( USER_ATT , new UserBean() );

        return LOGIN_VIEW;
    }

    @GetMapping("/Logout")
    public String logoutUser(  HttpSession session  ) {

        session.removeAttribute("token");
        session.removeAttribute("user");
        return LOGIN_PAGE;
    }

    @PostMapping("/Login")
    public String login(@ModelAttribute( USER_ATT ) UserBean user, BindingResult result, Model model, HttpSession session ) {

        String stringToken = authProxy.login( user );
        Object token = stringToken;
        session.setAttribute("token", token);

        LOGGER.info( " Token: " +  token );
        if ( token == null ) {

            return LOGIN_VIEW;
        }
        else
        {
            try {
                //MemberBean member = proxy.getMemberByMailAndPass( user.getUsername(), user.getPassword(), token );
                MemberBean member = proxy.getMemberByUsername( user.getUsername(), token );
                session.setAttribute("user", member );
                return USER_HOME_PAGE;
            }
          catch(FeignException f) {
                //EmployeeBean employee = proxy.getEmployeeByMailAndPass( user.getUsername(), user.getPassword(), token );
              EmployeeBean employee = proxy.getEmployeeByUsername( user.getUsername(), token );
                session.setAttribute("user", employee );
                return USER_HOME_PAGE;
            }


            //getEmployeeByMailAndPass


        }

    }


    /*@PostMapping("/login")
    public String checkMemberCred(@ModelAttribute( MEMBER_ATT ) MemberBean member, BindingResult result, Model model ) {

        try {

            MemberBean memberB = proxy.getMemberByMailAndPass( member.getAccountOwnerEmail(), member.getAccountOwnerPass() );
            //model.addAttribute( "memberSession", memberB );

            return  USER_HOME_VIEW;
        }
        catch ( FeignException feign ) {

            //result.addError( new FieldError( MEMBER_ATT, MEMBER_MAIL, ERROR_MESS ));
            model.addAttribute("errorMessage", ERROR_MESS);
            return LOGIN_VIEW;
        }

    }*/
}
