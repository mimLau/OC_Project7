package com.mimi.mlibrary.model.entity.borrowing;

import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.publication.Copy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowingJson {

    private Integer member;
    private Integer copy;
}
