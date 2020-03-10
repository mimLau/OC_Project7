package com.mimi.mlibrary.repository.account;

import com.mimi.mlibrary.model.entity.account.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query( "SELECT e FROM Employee e WHERE e.accountOwnerEmail= :mail AND e.accountOwnerPass= :pass" )
    Optional<Employee> getEmployeeByEmailAndPass(@Param("mail") String mail, @Param("pass") String pass );
}
