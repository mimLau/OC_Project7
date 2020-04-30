package org.mimi.clibrary.Beans.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountBean {

    private Integer id;
    private String accountOwnerFirstname;
    private String accountOwnerLastname;
    private String accountOwnerPass;
    private String accountOwnerEmail;
    private String accountOwnerPhoneNb;
    private boolean activeAccount;
    private LocalDate registrationDate;
    private String role;
}
