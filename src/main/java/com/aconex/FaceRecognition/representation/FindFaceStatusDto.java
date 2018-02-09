package com.aconex.FaceRecognition.representation;

public class FindFaceStatusDto {

    private String status;

    public FindFaceStatusDto(){

    }

    public FindFaceStatusDto(String status){

        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
