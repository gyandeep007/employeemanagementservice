package com.employeemanagement.service.impl;


import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.mapper.EmployeeMapper;
import com.employeemanagement.repository.DepartmentRepository;
import com.employeemanagement.repository.EmployeeRepository;
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
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Department department=  departmentRepository.findById(employeeDto.getDepartmentId()).
                orElseThrow(()->new ResourceNotFoundException("Department does not exist with given id :"+employeeDto.getDepartmentId()));

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employee.setDepartment(department);
      Employee savedEmployee=  employeeRepository.save(employee);
      return  EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
      Employee employee=  employeeRepository.findById(employeeId).
                           orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id :"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee(int pageNo,int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by("id"));
        List<Employee> employees = employeeRepository.findAll(pageable).getContent() ;

        List<EmployeeDto> employeeDtoList = employees.stream()
                                          .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                                          .collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Department department=  departmentRepository.findById(employeeDto.getDepartmentId()).
                orElseThrow(()->new ResourceNotFoundException("Department does not exist with given id :"+employeeDto.getDepartmentId()));

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employee.setDepartment(department);
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        employeeRepository.deleteById(employeeId);
    }
}
