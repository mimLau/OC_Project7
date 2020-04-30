package org.mimi.clibrary.proxies;

import org.mimi.clibrary.Beans.account.EmployeeBean;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.Loan.LoanBean;
import org.mimi.clibrary.Beans.publication.CopyBean;
import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient( name = "library-webservice", url = "localhost:8080" )
public interface FeignProxy {

    @GetMapping( value = "/Members" )
    List<MemberBean> getAllMembers();

    @GetMapping( value ="/Members", params = { "mail", "pass" } )
    MemberBean getMemberByMailAndPass( @RequestParam("mail") String mail, @RequestParam("pass") String pass, @RequestHeader("Authorization") Object accessToken );

    @GetMapping( value ="/Members", params = { "username" } )
    MemberBean getMemberByUsername( @RequestParam("username") String username, @RequestHeader("Authorization") Object accessToken );


    @GetMapping( value = "/Members", params = "id" )
    MemberBean getMemberById( @RequestParam("id") int id );


    @GetMapping(value = "/Employees", params = { "mail", "pass"} )
    EmployeeBean getEmployeeByMailAndPass( @RequestParam("mail") String mail, @RequestParam("pass") String pass, @RequestHeader("Authorization") Object accessToken);

    @GetMapping( value ="/Employees", params = { "username" } )
    EmployeeBean getEmployeeByUsername( @RequestParam("username") String username, @RequestHeader("Authorization") Object accessToken );



    @GetMapping( value = "/Publications" )
    List<PublicationBean> getAllPublications();

    @GetMapping (value = "/Publications/{id}" )
    PublicationBean getPublicationsById( @PathVariable("id") int id );

    @GetMapping( value = "/Publications", params = "title" )
    List<PublicationBean> getAllPublicationsByTitle( @RequestParam String title );

    @GetMapping( value ="/Publications/criterias", params = { "author", "title", "category", "editor", "libId" })
    List<PublicationBean> getPublicationByCriteria( @RequestParam String author, @RequestParam String title , @RequestParam String category,
                                                     @RequestParam String editor, @RequestParam(required = false, defaultValue = "0") int libId );

    @GetMapping( value = "/Libraries" )
    List<LibraryBean> getAllLibraries();


    @GetMapping( value = "/Copies/{id}" )
    CopyBean findCopyById( @PathVariable int id, @RequestHeader("Authorization") Object accessToken );

    @GetMapping( value = "/Copies/publication", params = "pubId")
    List<CopyBean> getAvailableCopiesByLibrary( @RequestParam int pubId  );



    @GetMapping( "/Loans/Members/{id}" )
    List<LoanBean> findAllByMemberId( @PathVariable int id, @RequestHeader("Authorization") Object accessToken );

    @PutMapping( "/Loans/return/{LoanId}" )
    void extendLoanReturnDate( @PathVariable int LoanId, @RequestHeader("Authorization") Object accessToken  );

    @GetMapping( "/Loans" )
    List<LoanBean> getAllLoans( @RequestHeader("Authorization") Object accessToken );


    @GetMapping( "/Loans/delay" )
    List<LoanBean> findByDelay( @RequestHeader("Authorization") Object accessToken);
}
