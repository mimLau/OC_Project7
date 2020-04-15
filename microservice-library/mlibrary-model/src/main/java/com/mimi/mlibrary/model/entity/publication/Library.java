package com.mimi.mlibrary.model.entity.publication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Libraries")
public class Library implements Serializable {

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
    @Column(nullable = false)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "library")
    private List<Copy> copies;
}
