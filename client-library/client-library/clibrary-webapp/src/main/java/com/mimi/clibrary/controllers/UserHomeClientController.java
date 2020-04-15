package com.mimi.clibrary.controllers;

import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserHomeClientController {

    private FeignProxy feignProxy;
    private static final String USER_HOME_VIEW = "userHome";

    public UserHomeClientController(FeignProxy feignProxy) {
        this.feignProxy = feignProxy;
    }


    @GetMapping("/user/home")
    public String homePage( Model model ) {

        return USER_HOME_VIEW;

    }
}
