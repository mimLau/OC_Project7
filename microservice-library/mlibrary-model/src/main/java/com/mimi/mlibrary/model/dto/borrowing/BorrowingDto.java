package com.mimi.mlibrary.model.dto.borrowing;

import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.borrowing.BorrowingStatus;
import com.mimi.mlibrary.model.entity.publication.Copy;
import java.time.LocalDate;


public class BorrowingDto {

    private Integer id;

    private LocalDate returnDate;
    private LocalDate borrowingDate;
    private int reminderNb;
    private boolean extented;
    private String borrowingStatus;
    private Copy copy;
    private Member member;

    public BorrowingDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate( LocalDate borrowingDate ) {
        this.borrowingDate = borrowingDate;
    }

    public int getReminderNb() {
        return reminderNb;
    }

    public void setReminderNb(int reminderNb) {
        this.reminderNb = reminderNb;
    }

    public boolean isExtented() {
        return extented;
    }

    public void setExtented(boolean extented) {
        this.extented = extented;
    }

    public String getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(String borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
