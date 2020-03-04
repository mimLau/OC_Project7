package com.mimi.mlibrary.model.dest.borrowing;

import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.model.source.borrowing.BorrowingStatus;
import com.mimi.mlibrary.model.source.publication.Copy;


public class BorrowingDto {

    private Integer id;

    private String returnDate;
    private String borrowingDate;
    private int reminderNb;
    private boolean extented;
    private BorrowingStatus borrowingStatus;
    private Copy copy;
    private MemberAccount member;

    public BorrowingDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(String borrowingDate) {
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

    public BorrowingStatus getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(BorrowingStatus borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public MemberAccount getMember() {
        return member;
    }

    public void setMember(MemberAccount member) {
        this.member = member;
    }
}
