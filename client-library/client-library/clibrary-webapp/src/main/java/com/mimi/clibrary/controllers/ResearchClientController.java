package com.mimi.clibrary.controllers;

import feign.FeignException;
import jdk.internal.org.jline.utils.Log;
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
public class ResearchClientController {
    private FeignProxy feignProxy;
    private static final String RESEARCH_VIEW = "research";
    private static final String PUBLICATION_RESULT_PAGE = "redirect:/publication/result";
    private static final String FORMCOMMAND_ATT = "researchFormCommand";
    private static final String ERROR_MESS = "Pas de résultat";
    final static Logger logger  = LogManager.getLogger(ResearchClientController.class);

    public ResearchClientController( FeignProxy feignProxy ) {
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

        Map<String, Object> map = new HashMap<String, Object>();
        int selectedLibrarieId = 0;

        if( researchFormCommand.getCheckboxSelectedValue()  != null ) {
            selectedLibrarieId = Integer.parseInt(researchFormCommand.getCheckboxSelectedValue());

        }
        map.put("libId", selectedLibrarieId);

        if( researchFormCommand.getSelectedCat()  != null && !researchFormCommand.getSelectedCat().isEmpty())
            map.put("cat",  researchFormCommand.getSelectedCat());
        else
            map.put("cat", null);

        if( researchFormCommand.getSelectedEdit()  != null && !researchFormCommand.getSelectedEdit().isEmpty())
            map.put("edit",  researchFormCommand.getSelectedEdit());
        else
            map.put("edit", null);

        if( researchFormCommand.getAutorTextField()  != null && !researchFormCommand.getAutorTextField().isEmpty() )
            map.put("author",  researchFormCommand.getAutorTextField());
        else
            map.put("author", null);

        if( researchFormCommand.getTitleTextField()  != null && !researchFormCommand.getTitleTextField().isEmpty() )
            map.put("title",  researchFormCommand.getTitleTextField());
        else
            map.put("title", null);


        Map<String, Integer> test  = new HashMap<String, Integer>();
        test.put("test", 23);

       /* Log.error("test" + test.get("test"));

        String cat =  (String) map.get("cat");
        Log.error("(String) map.get(categor)" + cat);*/

        try {

            List<PublicationBean> publications = feignProxy.getPublicationByCrit( (String) map.get("author"), (String) map.get("title"), (String) map.get("cat"), (String) map.get("editor"), (Integer) map.get("libId") );



            session.setAttribute("publications", publications);

            return PUBLICATION_RESULT_PAGE;

        } catch ( FeignException feign ) {

            model.addAttribute("errorMessage", ERROR_MESS);
            return RESEARCH_VIEW;
        }

    }
}
