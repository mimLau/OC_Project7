package com.mimi.mlibrary.repository.account;

import com.mimi.mlibrary.model.entity.account.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
