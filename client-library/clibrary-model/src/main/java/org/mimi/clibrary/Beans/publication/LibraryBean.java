package org.mimi.clibrary.Beans.publication;

import java.util.List;

public class LibraryBean {

    private Integer id;
    private String address;
    private String name;
    private List<CopyBean> copies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CopyBean> getCopies() {
        return copies;
    }

    public void setCopies(List<CopyBean> copies) {
        this.copies = copies;
    }
}
