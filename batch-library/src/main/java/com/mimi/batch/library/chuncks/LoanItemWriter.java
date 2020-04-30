package com.mimi.batch.library.chuncks;

import com.mimi.batch.library.model.Loan;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LoanItemWriter implements ItemWriter<Loan> {

    @Override
    public void write(List<? extends Loan> items) throws Exception {

        StaxEventItemWriter<Loan> writer = new StaxEventItemWriter<Loan>();
        writer.setRootTagName( "Loans" );
        writer.setResource( new FileSystemResource("/xml/loans.xml") );
        writer.setMarshaller( marshaller() );
    }

    private XStreamMarshaller marshaller() {
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> map = new HashMap<>();
        map.put( "Loans", Loan.class );
        marshaller.setAliases( map );
        return marshaller;
    }
}
