package com.mimi.clibrary.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.borrowing.BorrowingBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BorrowingClientController {
    final static Logger logger  = LogManager.getLogger(BorrowingClientController.class);

    private FeignProxy feignProxy;

    public BorrowingClientController(FeignProxy feignProxy) {
        this.feignProxy = feignProxy;
    }

    @GetMapping("/userBorrowings")
    public String memberBorrowing( Model model, HttpSession session ) {

        MemberBean member = (MemberBean) session.getAttribute("user");
        Object token = session.getAttribute("token");
        List<BorrowingBean> borrowings = feignProxy.findAllByMemberId( member.getId(), token );

        model.addAttribute( "borrowings", borrowings );
        return "userBorrowings";
    }

    @GetMapping( "/extends" )
    public String extendBorrowingReturnDate( @RequestParam int id, HttpSession session ) {
        Object token = session.getAttribute("token");
        feignProxy.extendBorrowingReturnDate( id, token );

        return "redirect:/userBorrowings";
    }

    @GetMapping("/borrowings")
    public String borrowings( Model model, HttpSession session ) {

        Object token = session.getAttribute("token");
        List<BorrowingBean> borrowings = feignProxy.getAllBorrowings( token );
        model.addAttribute( "borrowings", borrowings );
        return "borrowings";
    }

    @GetMapping("/delays")
    public String delays( Model model, HttpSession session ) {

        Object token = session.getAttribute("token");
        List<BorrowingBean> borrowings = feignProxy.findByDelay( token );
        model.addAttribute( "borrowings", borrowings );
        return "delays";
    }
}
