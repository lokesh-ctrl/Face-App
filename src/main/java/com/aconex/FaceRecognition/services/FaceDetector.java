package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.representation.EmployeeDto;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.aconex.FaceRecognition.services.HttpEntityToJsonParserService.getFaceId;

@Service
public class FaceDetector{

    private FaceIdentity faceIdentity;
    private FaceAPIServices faceApiServices;

    @Autowired
    FaceDetector(FaceIdentity faceIdentity, FaceAPIServices faceApiServices){

        this.faceIdentity=faceIdentity;

        this.faceApiServices = faceApiServices;
    }


    public EmployeeDto detectFace(byte[] imageBytes){

        try {

            HttpEntity httpEntity = faceApiServices.faceDetectionRequestToFaceAPI(imageBytes);

            return faceIdentity.identifyFace(getFaceId(httpEntity), faceApiServices);

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}