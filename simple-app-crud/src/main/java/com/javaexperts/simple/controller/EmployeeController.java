package com.javaexperts.simple.controller;

import com.javaexperts.simple.exception.ResourceNotFoundException;
import com.javaexperts.simple.model.Employee;
import com.javaexperts.simple.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

@GetMapping("/{id}")
    public ResponseEntity<Employee> getEbyId(@PathVariable("id")Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exist for id: "+id));
    return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee with id not found"));
        updateEmployee.setEmailId(employee.getEmailId());
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee with id not found"));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
