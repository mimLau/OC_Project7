package com.mimi.mlibrary.model;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String firstname;
    private String lastname;


}
