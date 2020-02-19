package com.mimi.mlibrary.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String firstname;
    private String lastname;

    @OneToMany(mappedBy = "author")
    private List<Book> book;
}
