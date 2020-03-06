package com.mimi.mlibrary.model.entity.publication;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Newspaper")
public class Newspaper extends Publication implements Serializable {

}
