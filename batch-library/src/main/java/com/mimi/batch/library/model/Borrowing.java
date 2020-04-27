package com.mimi.batch.library.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {

    private boolean extented;
    private String borrowingStatus;
    private Member member;
    private int reminderNb;
    private LocalDate returnDate;
    private LocalDate borrowingDate;
    private Copy copy;


}
