package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dest.account.EmployeeDto;
import com.mimi.mlibrary.model.source.account.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = EmployeeMapperConfig.class )
public interface  EmployeeMapper {

    @InheritConfiguration( name = "mapEmployee")
    EmployeeDto map( Employee employee );
    List<EmployeeDto> map( List<Employee> employees );


}
