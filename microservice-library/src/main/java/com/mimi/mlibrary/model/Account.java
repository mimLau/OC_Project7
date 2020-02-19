package com.mimi.mlibrary.model;

import javax.persistence.*;

@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String creationDate;

    @OneToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

}
