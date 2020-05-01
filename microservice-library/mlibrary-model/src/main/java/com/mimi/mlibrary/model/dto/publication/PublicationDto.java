package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.publication.*;
import lombok.*;

import java.time.LocalDate;

import java.util.List;

@Getter @Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {

    private Integer id;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;
    private List<Copy> copies;
    private String title;
    private String identificationNb;
    private LocalDate publicationDate;
    private String category;
    private String subCategoryStr;
    private Editor editor;
    private Author author;



}
