package org.mimi.clibrary.Beans.publication;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public  class PublicationBean {

    private int id;
    private String title;
    private String identificationNb;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;
    private LocalDate publicationDate;
    private String category;
    private String subCategoryStr;
    private List<CopyBean> copies;
    private EditorBean editor;
    private AuthorBean author;
}
