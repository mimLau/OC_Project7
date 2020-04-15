package com.mimi.mlibrary.model.entity.publication;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Criteria {

    private String authorName;
    private String editorName;
    private String title;
    private Category category;
    private LocalDate pubDate;
    private int libId;
}
