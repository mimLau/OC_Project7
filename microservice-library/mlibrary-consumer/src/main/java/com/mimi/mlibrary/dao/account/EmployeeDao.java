package com.mimi.mlibrary.dao.account;

import com.mimi.mlibrary.model.source.account.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeAccount, Integer> {
}
