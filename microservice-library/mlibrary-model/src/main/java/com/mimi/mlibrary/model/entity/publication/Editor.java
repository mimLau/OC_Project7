package com.mimi.mlibrary.model.entity.publication;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "editors")
public class Editor {

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
    private String name;

    @JsonManagedReference(value="publication_editor")
    @OneToMany(mappedBy = "editor")
    private List<Publication> publications;
}
