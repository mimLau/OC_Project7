package com.mimi.mlibrary.model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User {
}
