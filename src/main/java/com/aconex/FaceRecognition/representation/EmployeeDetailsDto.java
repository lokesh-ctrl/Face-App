package com.aconex.FaceRecognition.representation;

public class EmployeeDetailsDto {

    private String eName;

    private String eId;

    private String status;

    private  String eDesignation;

    EmployeeDetailsDto(){

    }

    EmployeeDetailsDto(String eId,String eName,String eDesignation,String status){

        this.eId=eId;

        this.eName=eName;

        this.eDesignation=eDesignation;

        this.status=status;

    }

    public String geteId() {
        return eId;
    }

    public String geteName() {
        return eName;
    }

    public String geteDesignation() {
        return eDesignation;
    }

    public String getStatus() {
        return status;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void seteDesignation(String eDesignation) {
        this.eDesignation = eDesignation;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
