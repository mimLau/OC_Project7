package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dto.account.EmployeeDto;
import com.mimi.mlibrary.model.entity.account.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface EmployeeMapperConfig extends AccountMapperConfig {

    @InheritConfiguration( name = "mapAccount")
    void mapEmployee( Employee employee, @MappingTarget EmployeeDto employeeDto );
}
