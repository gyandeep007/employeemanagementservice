package com.employeemanagement.service;

import com.employeemanagement.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployee(int pageNo,int pageSize);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);
}
