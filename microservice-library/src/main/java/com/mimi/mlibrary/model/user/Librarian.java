package com.mimi.mlibrary.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User implements Serializable {
}
