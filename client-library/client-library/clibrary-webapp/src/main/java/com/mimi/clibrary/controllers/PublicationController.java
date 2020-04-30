package com.mimi.clibrary.controllers;


import org.mimi.clibrary.Beans.publication.CopyBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublicationController {

    private FeignProxy proxy;

    public PublicationController(FeignProxy proxy ) {
        this.proxy = proxy;
    }

    @GetMapping("/Publication")
    public String publication( Model model, @RequestParam int id ) {

        PublicationBean publication = proxy.getPublicationsById( id );
        List<CopyBean> copies = proxy.getAvailableCopiesByLibrary( id );//TODO A VERIFIER

        model.addAttribute( "publication", publication );
        model.addAttribute( "copies", copies );
        return "publication";
    }


}
