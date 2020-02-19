package com.mimi.mlibrary.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User {
}
