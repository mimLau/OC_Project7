package org.mimi.clibrary.Beans.borrowing;

import java.time.LocalDate;
import org.mimi.clibrary.Beans.account.MemberBean;
import org.mimi.clibrary.Beans.publication.CopyBean;

public class BorrowingBean {

    private Integer id;
    private LocalDate returnDate;
    private LocalDate borrowingDate;
    private boolean extented;
    private BorrowingBeanStatus borrowingStatus;
    private CopyBean copy;
    private MemberBean member;
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

    public boolean isExtented() {
        return extented;
    }

    public void setExtented(boolean extented) {
        this.extented = extented;
    }

    public BorrowingBeanStatus getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(BorrowingBeanStatus borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }

    public CopyBean getCopy() {
        return copy;
    }

    public void setCopy(CopyBean copy) {
        this.copy = copy;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getReminderNb() {
        return reminderNb;
    }

    public void setReminderNb(int reminderNb) {
        this.reminderNb = reminderNb;
    }
}
