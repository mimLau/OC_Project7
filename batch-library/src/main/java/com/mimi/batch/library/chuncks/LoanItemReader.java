package com.mimi.batch.library.chuncks;

import com.mimi.batch.library.model.Loan;
import com.mimi.batch.library.proxies.FeignProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemReader;

import java.util.List;

public class LoanItemReader implements ItemReader<Loan> {
    final static Logger LOGGER  = LogManager.getLogger( LoanItemReader.class );
    private int nextLoanIndex;
    private List<Loan> loans;
    private FeignProxy proxy;
    private String token;

    public LoanItemReader( FeignProxy proxy, String token ) {
        this.nextLoanIndex = 0;
        this.proxy = proxy;
        this.token = token;
    }

    @Override
    public Loan read() throws  Exception {
        LOGGER.info("Reading the information of the next Loan");
        loans =  this.proxy.getOutdatedLoanLists( token );

        Loan nextLoan = null;

        if ( nextLoanIndex < loans.size() ) {
            nextLoan = loans.get( nextLoanIndex );
            nextLoanIndex++;
        }


        if( nextLoan!= null )
            LOGGER.info("Retrieve users emails from Loans where return date is outdated: " + nextLoan.getMember().getAccountOwnerEmail());

        return nextLoan;
    }


    /*
    @Nullable
	@Override
	public Loan read() {
	    if (!Loans.isEmpty()) {
                return Loans.remove(0);
        }
        return null;
    }*/

}
