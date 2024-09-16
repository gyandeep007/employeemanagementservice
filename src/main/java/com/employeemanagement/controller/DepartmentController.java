package com.employeemanagement.controller;


import com.employeemanagement.dto.DepartmentDto;
import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.service.DepartmentService;
import com.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;


    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize ){
        List<DepartmentDto> departments = departmentService.getAllDepartment(pageNo,pageSize);
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody  DepartmentDto departmentDto){
        DepartmentDto savedDepartment  = departmentService.addDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto updateDepartment = departmentService.updateDepartment(departmentDto);
        return new ResponseEntity<>(updateDepartment,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
