package com.aconex.FaceRecognition.representation;

public class EmployeeDto {

    private String employeeId;
    private String name;
    private String designation;
    private int isAdmin;

    public EmployeeDto(){

    }
    public EmployeeDto(String employeeId,String name, String designation,int isAdmin){

        this.employeeId=employeeId;
        this.name=name;
        this.designation=designation;
        this.isAdmin=isAdmin;
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

    public int getIsAdmin() {
        return isAdmin;
    }
}
