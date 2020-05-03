package com.mimi.clibrary.controllers;

import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mimi.clibrary.Beans.publication.LibraryBean;
import org.mimi.clibrary.Beans.publication.PublicationBean;
import org.mimi.clibrary.Beans.utils.ResearchFormCommand;
import org.mimi.clibrary.proxies.FeignProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResearchController {

    private FeignProxy feignProxy;

    private static final String RESEARCH_VIEW = "research";
    private static final String RESEARCH_PAGE = "redirect:/Research";
    private static final String PUBLICATION_RESULT_PAGE = "redirect:/Publication/result";
    private static final String FORMCOMMAND_ATT = "researchFormCommand";
    private static final String ERROR_SEARCH = "Aucun résultat ne correspond à votre recherche.";

    public ResearchController(FeignProxy feignProxy ) {
        this.feignProxy = feignProxy;
    }


    @ModelAttribute("category")
    public String[] getCategoryValues() {
        return new String[] {
                "Livres", "Journaux", "Revues"
        };
    }
    @ModelAttribute("editor")
    public String[] getEditorValues() {
        return new String[] {
                "Belin Éducation", "Gallimard", "Ldp Jeunesse", "Nathan"
        };
    }



    @GetMapping("/Research")
    public String researchPage( Model model ) {

        List<LibraryBean> libraries = feignProxy.getAllLibraries();
        model.addAttribute( "libraries", libraries );
        model.addAttribute( FORMCOMMAND_ATT, new ResearchFormCommand() );
        return RESEARCH_VIEW;
    }


    @PostMapping("/Research")
    public String researchForm(@ModelAttribute(FORMCOMMAND_ATT) ResearchFormCommand researchFormCommand, HttpSession session, Model model ) {

        int selectedLibrarieId = 0;
        Map<String, Object> criteriaMap = new HashMap<>();

        if( researchFormCommand.getCheckboxSelectedValue()  != null ) {
            selectedLibrarieId = Integer.parseInt(researchFormCommand.getCheckboxSelectedValue());

        }
        criteriaMap.put("libId", selectedLibrarieId);

        if( researchFormCommand.getSelectedCat()  != null && !researchFormCommand.getSelectedCat().isEmpty())
            criteriaMap.put("cat",  researchFormCommand.getSelectedCat());
        else
            criteriaMap.put("cat", null);

        if( researchFormCommand.getSelectedEdit()  != null && !researchFormCommand.getSelectedEdit().isEmpty())
            criteriaMap.put("editor",  researchFormCommand.getSelectedEdit());
        else
            criteriaMap.put("editor", null);

        if( researchFormCommand.getAutorTextField()  != null && !researchFormCommand.getAutorTextField().isEmpty() )
            criteriaMap.put("author",  researchFormCommand.getAutorTextField());
        else
            criteriaMap.put("author", null);

        if( researchFormCommand.getTitleTextField()  != null && !researchFormCommand.getTitleTextField().isEmpty() )
            criteriaMap.put("title",  researchFormCommand.getTitleTextField());
        else
            criteriaMap.put("title", null);


        try {
            List<PublicationBean> publications = feignProxy.getPublicationByCriteria( (String) criteriaMap.get("author"), (String) criteriaMap.get("title"), (String) criteriaMap.get("cat"), (String) criteriaMap.get("editor"), (Integer) criteriaMap.get("libId") );

            session.setAttribute("publications", publications);
            session.removeAttribute("errorResearch");
            return PUBLICATION_RESULT_PAGE;

        } catch ( FeignException feign ) {

            session.setAttribute("errorResearch", ERROR_SEARCH);
            return RESEARCH_PAGE;
        }

    }
}
