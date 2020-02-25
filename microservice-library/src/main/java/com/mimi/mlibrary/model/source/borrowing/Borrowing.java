package com.mimi.mlibrary.model.source.borrowing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mimi.mlibrary.model.source.account.MemberAccount;
import com.mimi.mlibrary.model.source.publication.Copy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Borrowings")
public class Borrowing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String returnDate;
    private String borrowingDate;
    private int reminderNb;

    @Type(type = "numeric_boolean")
    private boolean extented;

    @Enumerated(EnumType.STRING)
    private BorrowingStatus borrowingStatus;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn
    private Copy copy;

    @ManyToOne
    @JoinColumn
    private MemberAccount Member;

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
        return Member;
    }

    public void setMember(MemberAccount Member) {
        this.Member = Member;
    }
}
