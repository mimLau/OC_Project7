package com.mimi.mlibrary.model.entity.account;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Account {

}
