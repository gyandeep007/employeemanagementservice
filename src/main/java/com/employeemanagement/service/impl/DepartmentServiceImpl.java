package com.employeemanagement.service.impl;


import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.mapper.DepartmentMapper;
import com.employeemanagement.mapper.EmployeeMapper;
import com.employeemanagement.repository.DepartmentRepository;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.service.DepartmentService;
import com.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
      Department savedDepartment=  departmentRepository.save(department);
      return  DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
      Department department=  departmentRepository.findById(departmentId).
                           orElseThrow(()->new ResourceNotFoundException("Department does not exist with given id :"+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment(int pageNo,int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by("id"));
        List<Department> departments = departmentRepository.findAll(pageable).getContent() ;

        List<DepartmentDto> departmentDtoList = departments.stream()
                                          .map(department -> DepartmentMapper.mapToDepartmentDto(department))
                                          .collect(Collectors.toList());
        return departmentDtoList;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {

        departmentRepository.deleteById(departmentId);
    }
}
