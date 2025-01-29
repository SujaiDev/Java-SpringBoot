package com.example.cityclimateapi.controller;


import com.example.cityclimateapi.model.SqlEmployee;
import com.example.cityclimateapi.service.SqlEmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlEmployeeController {

    private final SqlEmployeeService sqlEmployeeService;

    public SqlEmployeeController(SqlEmployeeService sqlEmployeeService) {
        this.sqlEmployeeService = sqlEmployeeService;
    }

    @PostMapping("/sqlEmployee")
    public SqlEmployee createEmployee(@RequestBody SqlEmployee sqlEmployee){
        return sqlEmployeeService.saveEmployee(sqlEmployee);
    }

}
