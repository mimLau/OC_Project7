package org.mimi.clibrary.proxies;

import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient( name = "mlibrary-webservice", url = "localhost:8080" )
public interface FeignProxy {

    @GetMapping( value = "/Members" )
    List<MemberBean> getAllMembers();

    @GetMapping( value ="/Members", params = { "mail", "pass" } )
    MemberBean getMemberByNameAndPass(@RequestParam("mail") String mail, @RequestParam("pass") String pass );

    @GetMapping( value = "/Members", params = "id" )
    MemberBean getMemberById(@RequestParam("id") int id );



    @GetMapping(value = "/Publications")
    List<PublicationBean> getAllPublications();

    @GetMapping(value = "/Publications", params = "id")
    PublicationBean getPublicationsById(@RequestParam("id") int id);



    @GetMapping(value = "/Libraries")
    List<LibraryBean> getAllLibraries();

}
