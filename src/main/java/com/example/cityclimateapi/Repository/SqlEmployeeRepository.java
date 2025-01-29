package com.example.cityclimateapi.Repository;

import com.example.cityclimateapi.model.SqlEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlEmployeeRepository extends JpaRepository<SqlEmployee, String> {
}
