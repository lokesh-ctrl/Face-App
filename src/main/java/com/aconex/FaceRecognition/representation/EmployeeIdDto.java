package com.aconex.FaceRecognition.representation;

public class EmployeeIdDto {

    private String employeeId;

    public EmployeeIdDto(){

    }

    public EmployeeIdDto(String employeeId){

        this.employeeId=employeeId;

    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}