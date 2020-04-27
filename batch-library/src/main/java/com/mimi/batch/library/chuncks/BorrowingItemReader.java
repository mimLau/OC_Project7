package com.mimi.batch.library.chuncks;

import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.proxies.FeignProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemReader;

import java.util.List;

public class BorrowingItemReader implements ItemReader<Borrowing> {
    final static Logger LOGGER  = LogManager.getLogger( BorrowingItemReader.class );
    private int nextBorrowingIndex;
    private List<Borrowing> borrowings;
    private FeignProxy proxy;
    private String token;

    public BorrowingItemReader( FeignProxy proxy, String token ) {
        this.nextBorrowingIndex = 0;
        this.proxy = proxy;
        this.token = token;
    }

    @Override
    public Borrowing read() throws  Exception {
        LOGGER.info("Reading the information of the next borrowing");
        borrowings =  this.proxy.getOutdatedBorrowingLists( token );

        Borrowing nextBorrowing = null;

        if ( nextBorrowingIndex < borrowings.size() ) {
            nextBorrowing = borrowings.get( nextBorrowingIndex );
            nextBorrowingIndex++;
        }


        if( nextBorrowing!= null )
            LOGGER.info("Retrieve users emails from borrowings where return date is outdated: " + nextBorrowing.getMember().getAccountOwnerEmail());

        return nextBorrowing;
    }


    /*
    @Nullable
	@Override
	public Borrowing read() {
	    if (!borrowings.isEmpty()) {
                return borrowings.remove(0);
        }
        return null;
    }*/

}
