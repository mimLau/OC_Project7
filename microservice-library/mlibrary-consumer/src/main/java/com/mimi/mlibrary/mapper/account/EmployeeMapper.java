package com.mimi.mlibrary.mapper.account;

import com.mimi.mlibrary.model.dto.account.EmployeeDto;
import com.mimi.mlibrary.model.entity.account.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( config = EmployeeMapperConfig.class )
public interface  EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    @InheritConfiguration( name = "mapEmployee")
    EmployeeDto toDto( Employee employee );
    List<EmployeeDto> toDtoList( List<Employee> employees );

    Employee toEntity( EmployeeDto employeeDto );
    List<Employee> toEntityList( List<EmployeeDto> employeeDtos );


}
