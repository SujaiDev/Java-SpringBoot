package com.example.cityclimateapi.service;


import com.example.cityclimateapi.Repository.EmployeeRepository;
import com.example.cityclimateapi.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}


