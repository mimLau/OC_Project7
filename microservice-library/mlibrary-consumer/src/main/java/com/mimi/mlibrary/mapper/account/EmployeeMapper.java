package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dto.account.EmployeeDto;
import com.mimi.mlibrary.model.entity.account.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = EmployeeMapperConfig.class )
public interface  EmployeeMapper {

    @InheritConfiguration( name = "mapEmployee")
    EmployeeDto empToDto( Employee employee );
    List<EmployeeDto> empToDtoList( List<Employee> employees );

    /*Employee dtoToEmp( EmployeeDto employeeDto );
    List<Employee> dtoToEmpList( List<EmployeeDto> employeeDtos );*/


}
