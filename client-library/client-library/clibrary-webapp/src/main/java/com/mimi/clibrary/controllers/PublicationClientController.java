package com.mimi.clibrary.controllers;


import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class PublicationClientController {

    private FeignProxy proxy;

    public PublicationClientController(FeignProxy proxy ) {
        this.proxy = proxy;
    }

    @RequestMapping("/Publications")
    public String publication( Model model) {

        List<PublicationBean> publications = proxy.getAllPublications();
        model.addAttribute( "publications", publications );
        return "publication";
    }


}
