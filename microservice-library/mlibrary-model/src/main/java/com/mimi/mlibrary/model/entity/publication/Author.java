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
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String alias;

    @JsonManagedReference(value="publication_author")
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Publication> publications;

}
