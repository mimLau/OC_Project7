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

    private static final String LOGIN_VIEW = "login";
    private static final String LOGIN_PAGE = "redirect:/Login";
    private static final String USER_HOME_PAGE = "redirect:/User/home";
    private static final String ERROR_LOGIN = "Utilisateur n'existe pas";

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
        session.removeAttribute("errorLogin");
        return LOGIN_PAGE;
    }

    @PostMapping("/Login")
    public String login(@ModelAttribute( USER_ATT ) UserBean user, HttpSession session ) {

        String stringToken = authProxy.login( user );
        Object token = stringToken;
        session.setAttribute("token", token);

        LOGGER.info( " Token: " +  token );
        if ( token == null ) {

            session.setAttribute("errorLogin", ERROR_LOGIN);
            return LOGIN_VIEW;
        }
        else
        {
            try {
                MemberBean member = proxy.getMemberByUsername( user.getUsername(), token );
                session.setAttribute("user", member );
                return USER_HOME_PAGE;
            }
          catch( FeignException f) {
              EmployeeBean employee = proxy.getEmployeeByUsername( user.getUsername(), token );
                session.setAttribute("user", employee );
                return USER_HOME_PAGE;
            }


        }

    }

}
