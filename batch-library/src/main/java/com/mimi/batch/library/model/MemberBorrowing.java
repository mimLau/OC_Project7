package com.mimi.batch.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberBorrowing {

    private Member member;
    private List<Borrowing> borrowings;
}
