package com.example.cityclimateapi.service;

import com.example.cityclimateapi.Repository.SqlEmployeeRepository;
import com.example.cityclimateapi.model.SqlEmployee;
import org.springframework.stereotype.Service;

@Service
public class SqlEmployeeService {

    private final SqlEmployeeRepository sqlEmployeeRepository;

    public SqlEmployeeService(SqlEmployeeRepository sqlEmployeeRepository) {
        this.sqlEmployeeRepository = sqlEmployeeRepository;
    }

    public SqlEmployee saveEmployee(SqlEmployee sqlEmployee) {
        return sqlEmployeeRepository.save(sqlEmployee);
    }
}