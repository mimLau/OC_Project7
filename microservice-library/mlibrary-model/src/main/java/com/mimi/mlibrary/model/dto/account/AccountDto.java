package com.mimi.mlibrary.model.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Integer id;
    private String accountOwnerUsername;
    private String accountOwnerFirstname;
    private String accountOwnerLastname;
    //private String accountOwnerPass;
    private String accountOwnerEmail;
    private String accountOwnerPhoneNb;
    private boolean activeAccount;
    private String role;
    private LocalDate registrationDate;

}
