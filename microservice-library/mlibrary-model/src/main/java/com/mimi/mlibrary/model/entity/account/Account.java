package com.mimi.mlibrary.model.entity.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "accounts")
@DiscriminatorColumn(name = "User_type")
public class Account implements Serializable {

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
    private String accountOwnerUsername;
    @Column(nullable = false)
    private String accountOwnerFirstname;
    @Column(nullable = false)
    private String accountOwnerLastname;
   /* @Column(nullable = false)
    private String accountOwnerPass;*/
    @Column(nullable = false)
    private String accountOwnerEmail;
    @Column(nullable = false)
    private String accountOwnerPhoneNb;
    @Column(nullable = false)
    private boolean activeAccount;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate registrationDate;

}