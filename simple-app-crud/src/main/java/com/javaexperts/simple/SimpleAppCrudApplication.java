package com.javaexperts.simple;

import com.javaexperts.simple.model.Employee;
import com.javaexperts.simple.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleAppCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAppCrudApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args)throws Exception{
		Employee employee=new Employee();
		employee.setFirstName("FirstName");
		employee.setLastName("LastName");
		employee.setEmailId("firstLast@javaexperts.com");
		employeeRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirstName("FirstName1");
		employee1.setLastName("LastName1");
		employee1.setEmailId("firstLast1@javaexperts.com");
		employeeRepository.save(employee1);
	}
}
