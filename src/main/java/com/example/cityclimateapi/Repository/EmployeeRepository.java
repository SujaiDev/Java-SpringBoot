package com.example.cityclimateapi.Repository;

import com.example.cityclimateapi.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
