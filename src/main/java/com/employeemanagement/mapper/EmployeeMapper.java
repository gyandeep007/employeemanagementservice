package com.employeemanagement.mapper;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                             employee.getId(),
                             employee.getFirstName(),
                             employee.getLastName(),
                             employee.getEmail(),
                employee.getDepartment()!= null?employee.getDepartment().getId():null
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new  Employee();

        employee.setId( employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
                employee.setLastName(employeeDto.getLastName());
                employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}
