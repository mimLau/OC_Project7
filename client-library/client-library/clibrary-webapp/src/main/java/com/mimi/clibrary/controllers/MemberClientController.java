package com.mimi.clibrary.controllers;

import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MemberClientController {

    private FeignProxy feignProxy;

    public MemberClientController(FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @RequestMapping("/Members")
    public String publication( Model model) {

        List<MemberBean> members = feignProxy.getAllMembers();
        model.addAttribute( "member", members );
        return "member";
    }


}
