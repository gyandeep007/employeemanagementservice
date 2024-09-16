package com.employeemanagement.service;

import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.mapper.DepartmentMapper;

import java.util.List;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartment(int pageNo,int pageSize);
    DepartmentDto updateDepartment(DepartmentDto departmentDto);
    void deleteDepartment(Long departmentId);
}
