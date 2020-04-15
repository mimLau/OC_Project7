package com.mimi.clibrary.controllers;

import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.Beans.utils.FormCommand;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ResearchClientController {
    private FeignProxy feignProxy;
    private static final String RESEARCH_VIEW = "research";
    private static final String PUBLICATION_RESULT_PAGE = "redirect:/publication/result";
    private static final String FORMCOMMAND_ATT = "formCommand";
    private static final String ERROR_MESS = "Pas de résultat";
    final static Logger logger  = LogManager.getLogger(ResearchClientController.class);

    public ResearchClientController( FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }

    @ModelAttribute("criteria")
    public String[] getCriteriaValues() {
        return new String[] {
                "Titre", "Titre exact", "Auteur"
        };
    }


    @GetMapping("/Research")
    public String researchPage( Model model ) {

        List<LibraryBean> libraries = feignProxy.getAllLibraries();
        model.addAttribute( "libraries", libraries );
        model.addAttribute( FORMCOMMAND_ATT, new FormCommand() );

        return "research";
    }


    @PostMapping("/Research")
    public String researchForm( @ModelAttribute(FORMCOMMAND_ATT) FormCommand formCommand, HttpSession session, Model model ) {
        int selectedLibrarieId;
        if( formCommand.getCheckboxSelectedValue()  != null )
            selectedLibrarieId = Integer.parseInt( formCommand.getCheckboxSelectedValue() );
        else
            selectedLibrarieId =0;

        try {

            List<PublicationBean> publications = feignProxy.getPublicationByCriteria( formCommand.getDropdownSelectedValue(),
                                                                                      formCommand.getTextField(), selectedLibrarieId );



            session.setAttribute("publications", publications);

            return PUBLICATION_RESULT_PAGE;

        } catch ( FeignException feign ) {

            model.addAttribute("errorMessage", ERROR_MESS);
            return RESEARCH_VIEW;
        }

    }
}
