package com.mimi.mlibrary.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="Borrowings")
public class Borrowing {

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

    @ManyToOne()
    @JoinColumn(name="borrowing_fk")
    private Copy copy;

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
}
