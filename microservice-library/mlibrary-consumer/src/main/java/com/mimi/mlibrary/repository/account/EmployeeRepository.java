package com.mimi.mlibrary.repository.account;

import com.mimi.mlibrary.model.entity.account.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query( "SELECT e FROM Employee e WHERE e.accountOwnerUsername= :username" )
    Optional<Employee> getEmployeeByUsername( @Param("username") String username );


}
