package com.mimi.mlibrary.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable {
}
