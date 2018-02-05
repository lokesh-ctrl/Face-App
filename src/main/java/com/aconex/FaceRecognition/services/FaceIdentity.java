package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.representation.EmployeeDto;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.FaceRecognition.services.HttpEntityToJsonParserService.getPersonId;


@Service
public class FaceIdentity{

    private EmployeeService employeeService;

    @Autowired
    FaceIdentity(EmployeeService employeeService){

        this.employeeService = employeeService;
    }


    public EmployeeDto identifyFace(String faceId, FaceAPIServices faceApiServices){


        try{

            HttpEntity httpEntity= faceApiServices.faceIdentifyRequestToFaceAPI(faceId);

            String personId=getPersonId(httpEntity);

            if(personId==null) new EmployeeDto();

            return employeeService.getPersonDetails(personId);

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}