package com.aconex.FaceRecognition.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private String personId;
    private String employeeId;
    private String name;
    private String designation;

    public Employee(){

    }
    public Employee(String personId, String employeeId, String name, String designation){

        this.personId = personId;
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
    }

    public String getPersonId() {
        return personId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }
}

