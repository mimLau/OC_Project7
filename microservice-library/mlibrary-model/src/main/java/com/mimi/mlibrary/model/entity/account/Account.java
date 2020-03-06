package com.mimi.mlibrary.model.entity.account;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "accounts")
@DiscriminatorColumn(name = "User_type")
public abstract class Account implements Serializable {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;
    @Column(nullable = false)
    private String accountOwnerFirstname;
    @Column(nullable = false)
    private String accountOwnerLastname;
    @Column(nullable = false)
    private String accountOwnerPass;
    @Column(nullable = false)
    private String accountOwnerEmail;
    private String accountOwnerPhoneNb;
    @Column(nullable = false)
    private boolean activeAccount;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountOwnerFirstname() {
        return accountOwnerFirstname;
    }

    public void setAccountOwnerFirstname(String accountOwnerFirstname) {
        this.accountOwnerFirstname = accountOwnerFirstname;
    }

    public String getAccountOwnerLastname() {
        return accountOwnerLastname;
    }

    public void setAccountOwnerLastname(String accountOwnerLastname) {
        this.accountOwnerLastname = accountOwnerLastname;
    }

    public String getAccountOwnerPass() {
        return accountOwnerPass;
    }

    public void setAccountOwnerPass(String accountOwnerPass) {
        this.accountOwnerPass = accountOwnerPass;
    }

    public String getAccountOwnerEmail() {
        return accountOwnerEmail;
    }

    public void setAccountOwnerEmail(String accountOwnerEmail) {
        this.accountOwnerEmail = accountOwnerEmail;
    }

    public String getAccountOwnerPhoneNb() {
        return accountOwnerPhoneNb;
    }

    public void setAccountOwnerPhoneNb(String accountOwnerPhoneNb) {
        this.accountOwnerPhoneNb = accountOwnerPhoneNb;
    }

    public boolean isActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(boolean activeAccount) {
        this.activeAccount = activeAccount;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}