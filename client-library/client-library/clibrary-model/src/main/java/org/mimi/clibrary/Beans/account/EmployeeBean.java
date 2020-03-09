package org.mimi.clibrary.Beans.account;

public class EmployeeBean extends AccountBean {

    private RoleBean role;

    public EmployeeBean() {
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }
}
