package org.mimi.clibrary.Beans.publication;

import java.util.List;

public class LibraryBean {

    private Integer id;
    private String address;
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

    public List<CopyBean> getCopies() {
        return copies;
    }

    public void setCopies(List<CopyBean> copies) {
        this.copies = copies;
    }
}
