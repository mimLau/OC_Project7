package com.mimi.clibrary.controllers;


import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;

@Controller
public class PublicationController {

    private FeignProxy feignProxy;

    public PublicationController( FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @RequestMapping("/Publications")
    public String publication( Model model) {

        List<PublicationBean> publications = feignProxy.getAllPublications();
        model.addAttribute( "publications", publications );
        return "publication";
    }


}
