package com.mimi.clibrary.controllers;

import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LibraryClientController {

    private FeignProxy feignProxy;

    public LibraryClientController( FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @GetMapping("/Libraries")
    public String publication( Model model ) {
        List<LibraryBean> libraries = feignProxy.getAllLibraries();
        model.addAttribute( "libraries", libraries );
        return "library";
    }

}
