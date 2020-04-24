package com.mimi.batch.library.customItems;

import com.mimi.batch.library.model.Borrowing;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BorrowingItemWriter implements ItemWriter<Borrowing> {

    @Override
    public void write(List<? extends Borrowing> items) throws Exception {

        StaxEventItemWriter<Borrowing> writer = new StaxEventItemWriter<Borrowing>();
        writer.setRootTagName( "Borrowings" );
        writer.setResource( new FileSystemResource("/xml/borrowings.xml") );
        writer.setMarshaller( marshaller() );
    }

    private XStreamMarshaller marshaller() {
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> map = new HashMap<>();
        map.put( "Borrowings", Borrowing.class );
        marshaller.setAliases( map );
        return marshaller;
    }
}
