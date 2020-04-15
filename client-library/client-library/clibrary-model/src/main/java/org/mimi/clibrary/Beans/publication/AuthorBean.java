package org.mimi.clibrary.Beans.publication;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorBean {

    private Integer id;
    private String firstname;
    private String lastname;
    private String alias;
    private List<PublicationBean> publications;

    public AuthorBean() {
    }
}
