package com.mimi.clibrary.controllers;


import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublicationClientController {

    private FeignProxy proxy;

    public PublicationClientController(FeignProxy proxy ) {
        this.proxy = proxy;
    }

    @GetMapping("/Publication")
    public String publication(Model model, @RequestParam int id) {

        PublicationBean publication = proxy.getPublicationsById( id );

        model.addAttribute( "publication", publication );
        return "publication";
    }


}
