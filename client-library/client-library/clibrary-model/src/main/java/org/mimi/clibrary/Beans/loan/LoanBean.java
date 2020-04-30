package org.mimi.clibrary.Beans.loan;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.publication.CopyBean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanBean {

    private Integer id;
    private LocalDate returnDate;
    private LocalDate loanDate;
    private boolean extented;
    private String loanStatus;
    private CopyBean copy;
    private MemberBean member;
    private int reminderNb;

}
