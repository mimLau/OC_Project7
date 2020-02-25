package com.mimi.mlibrary.model.source.account;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "Employees")
public class EmployeeAccount extends Account {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
