package org.mimi.clibrary.Beans.publication;

import java.util.List;

public class AuthorBean {

    private Integer id;
    private String firstname;
    private String lastname;
    private String alias;
    private List<BookBean> book;

    public AuthorBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<BookBean> getBook() {
        return book;
    }

    public void setBook(List<BookBean> book) {
        this.book = book;
    }
}
