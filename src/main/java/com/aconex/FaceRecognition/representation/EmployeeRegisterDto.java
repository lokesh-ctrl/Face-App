package com.aconex.FaceRecognition.representation;

public class EmployeeRegisterDto {

    private String employeeName;

    private String[] employeeImages;

    private String employeeId;

    private String employeeDesignation;

    EmployeeRegisterDto(){

    }

    EmployeeRegisterDto(String employeeName,String[] employeeImages,String employeeId,String employeeDesignation){

        this.employeeName=employeeName;

        this.employeeImages=employeeImages;

        this.employeeId=employeeId;

        this.employeeDesignation=employeeDesignation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String[] getEmployeeImages() {
        return employeeImages;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeImages(String[] employeeImages) {
        this.employeeImages = employeeImages;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
}
