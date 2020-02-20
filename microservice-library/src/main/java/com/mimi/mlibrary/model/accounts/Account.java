package com.mimi.mlibrary.model.accounts;

import com.mimi.mlibrary.model.users.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String creationDate;

    @OneToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

}
