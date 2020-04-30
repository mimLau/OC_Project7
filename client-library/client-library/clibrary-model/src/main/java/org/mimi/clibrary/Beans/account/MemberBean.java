package org.mimi.clibrary.Beans.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mimi.clibrary.Beans.Loan.LoanBean;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberBean extends AccountBean {

    private String barcode;
    private int nbOfCurrentsLoans;
    private List<LoanBean> loans;


}
