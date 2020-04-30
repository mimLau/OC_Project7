package com.mimi.mlibrary.model.entity.loan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.publication.Copy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="loans")
public class Loan implements Serializable {

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
    private LocalDate returnDate;
    @Column(nullable = false)
    private LocalDate loanDate;
    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean extented;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    @JsonBackReference(value = "copy_Loan")
    @ManyToOne
    @JoinColumn(name = "copy_fk")
    private Copy copy;
    @JsonBackReference(value = "Loan_member")
    @ManyToOne
    @JoinColumn(name = "member_fk")
    private Member member;
    @Column(nullable = false)
    private int reminderNb;

}
