package com.mimi.mlibrary.model.source.publication;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Review")
public class Review extends Publication implements Serializable {


}
