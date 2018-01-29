package com.aconex.FaceRecognition.representation;


public class ImageDto {

    private String image;

    ImageDto(){

    }
    ImageDto(String image){
        this.image=image;
    }

    public String getImage(){
        return this.image;
    }



}
