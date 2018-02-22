package com.aconex.FaceRecognition.representation;

public class CreatePersonBodyDto {

    private String name;

    private  String userData;

    public CreatePersonBodyDto(){

    }
    public CreatePersonBodyDto(String name,String userData){

        this.name=name;

        this.userData=userData;
    }

    public String getname() {
        return name;
    }

    public String getuserData() {
        return userData;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setuserData(String userData) {
        this.userData = userData;
    }
}
