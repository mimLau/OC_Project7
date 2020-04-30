package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {


    private Integer id;
    private String firstname;
    private String lastname;
    private String alias;
    private List<Publication> publications;

}
