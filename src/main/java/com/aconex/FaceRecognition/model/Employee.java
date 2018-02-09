package com.aconex.FaceRecognition.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private String personid;
    private String employeeid;
    private String name;
    private String designation;
    private int isadmin=0;

    public Employee(){

    }
    public Employee(String personid, String employeeid, String name, String designation,int isadmin){

        this.personid = personid;
        this.employeeid = employeeid;
        this.name = name;
        this.designation = designation;
        this.isadmin=isadmin;
    }

    public String getPersonId() {
        return personid;
    }

    public String getEmployeeId() {
        return employeeid;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getIsAdmin() {
        return isadmin;
    }
}

