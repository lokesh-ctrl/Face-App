package com.aconex.FaceRecognition.representation;

public class EmployeeDto {

    String employeeId;
    String name;
    String designation;

    public EmployeeDto(){

    }
    public EmployeeDto(String employeeId,String name, String designation){

        this.employeeId=employeeId;
        this.name=name;
        this.designation=designation;
    }
}
