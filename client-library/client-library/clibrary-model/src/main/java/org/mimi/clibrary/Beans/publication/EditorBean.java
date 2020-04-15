package org.mimi.clibrary.Beans.publication;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditorBean {

    private Integer id;
    private String name;
    private List<PublicationBean> publications;

}
