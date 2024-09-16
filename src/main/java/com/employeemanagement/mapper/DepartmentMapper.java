package com.employeemanagement.mapper;

import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
