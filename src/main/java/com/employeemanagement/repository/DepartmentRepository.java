package com.employeemanagement.repository;

import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
