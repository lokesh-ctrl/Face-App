package com.aconex.FaceRecognition.representation;

public class RegistrationStatusDto {

    private String status;

    public RegistrationStatusDto(){

    }

    public RegistrationStatusDto(String status){

        this.status=status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
