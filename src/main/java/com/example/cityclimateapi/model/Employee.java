package com.example.cityclimateapi.model;


//import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;
    private String name;
    private String position;
    private double salary;

}
