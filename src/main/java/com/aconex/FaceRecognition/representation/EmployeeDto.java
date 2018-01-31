package com.aconex.FaceRecognition.representation;

public class EmployeeDto {

    private String employeeId;
    private String name;
    private String designation;

    public EmployeeDto(){

    }
    public EmployeeDto(String employeeId,String name, String designation){

        this.employeeId=employeeId;
        this.name=name;
        this.designation=designation;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getDesignation(){
        return designation;
    }
}
