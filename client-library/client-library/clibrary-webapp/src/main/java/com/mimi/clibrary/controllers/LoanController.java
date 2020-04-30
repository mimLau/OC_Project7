package com.mimi.clibrary.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.Loan.LoanBean;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class LoanController {
    final static Logger LOGGER  = LogManager.getLogger(LoanController.class);

    private FeignProxy feignProxy;

    public LoanController(FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @GetMapping("/UserLoans")
    public String memberLoan( Model model, HttpSession session ) {

        MemberBean member = (MemberBean) session.getAttribute("user");
        Object token = session.getAttribute("token");
        List<LoanBean> loans = feignProxy.findAllByMemberId( member.getId(), token );

        model.addAttribute( "loans", loans );
        model.addAttribute("toDay", LocalDate.now());
        return "userLoans";
    }

    @GetMapping( "/Extends" )
    public String extendLoanReturnDate( @RequestParam int id, HttpSession session ) {
        Object token = session.getAttribute("token");
        feignProxy.extendLoanReturnDate( id, token );

        return "redirect:/UserLoans";
    }

    @GetMapping("/Loans")
    public String Loans( Model model, HttpSession session ) {

        Object token = session.getAttribute("token");
        List<LoanBean> loans = feignProxy.getAllLoans( token );
        model.addAttribute( "loans", loans );
        model.addAttribute("toDay", LocalDate.now());
        return "loans";
    }

    @GetMapping("/Delays")
    public String delays( Model model, HttpSession session ) {

        Object token = session.getAttribute("token");
        List<LoanBean> loans = feignProxy.findByDelay( token );
        model.addAttribute( "loans", loans );
        model.addAttribute("toDay", LocalDate.now());
        return "delays";
    }
}
