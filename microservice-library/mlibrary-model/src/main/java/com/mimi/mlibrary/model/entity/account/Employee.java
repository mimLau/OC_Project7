package com.mimi.mlibrary.model.entity.account;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Account {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
