package com.mimi.batch.library.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Account {

    private Integer id;
    private String accountOwnerFirstname;
    private String accountOwnerLastname;
    private String accountOwnerEmail;
}
