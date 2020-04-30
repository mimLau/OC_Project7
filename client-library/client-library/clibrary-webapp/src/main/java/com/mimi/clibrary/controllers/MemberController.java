package com.mimi.clibrary.controllers;

import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {

    private FeignProxy feignProxy;

    public MemberController(FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @RequestMapping("/Members")
    public String publication( Model model) {

        List<MemberBean> members = feignProxy.getAllMembers();
        model.addAttribute( "member", members );
        return "member";
    }


}
