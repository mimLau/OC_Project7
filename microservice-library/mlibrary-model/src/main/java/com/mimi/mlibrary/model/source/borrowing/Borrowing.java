package com.mimi.mlibrary.model.source.borrowing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mimi.mlibrary.model.source.account.Member;
import com.mimi.mlibrary.model.source.publication.Copy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Borrowings")
public class Borrowing implements Serializable {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;

    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate returnDate;

    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate borrowingDate;

    @Column(nullable = false)
    @Type(type = "numeric_boolean")
    private boolean extented;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BorrowingStatus borrowingStatus;

    @Column(nullable = false)
    @JsonBackReference(value = "copy_borrowing")
    @ManyToOne
    @JoinColumn(name = "copy_fk")
    private Copy copy;

    @Column(nullable = false)
    @JsonBackReference(value = "borrowing_member")
    @ManyToOne
    @JoinColumn(name = "member_fk")
    private Member member;

    @Column(nullable = false)
    private int reminderNb;

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

    public void setBorrowingDate(LocalDate borrowingDate) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
