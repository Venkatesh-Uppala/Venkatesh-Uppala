package com.javaexperts.simple.repository;

import com.javaexperts.simple.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
