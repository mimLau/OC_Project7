package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto {


    private Integer id;
    private String firstname;
    private String lastname;
    private String alias;
    private List<Publication> publications;

}
