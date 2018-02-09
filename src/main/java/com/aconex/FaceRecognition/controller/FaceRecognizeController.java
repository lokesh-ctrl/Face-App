package com.aconex.FaceRecognition.controller;


import com.aconex.FaceRecognition.representation.EmployeeDto;
import com.aconex.FaceRecognition.representation.ImageDto;
import com.aconex.FaceRecognition.services.FaceDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/recognize")
public class FaceRecognizeController {

    private FaceDetector faceDetector;

    @Autowired
    FaceRecognizeController(FaceDetector faceDetector){

        this.faceDetector=faceDetector;
    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public EmployeeDto recognizeFace(@RequestBody ImageDto imageDto) {

        try {

            byte[] imageBytes = Base64.getDecoder().decode(imageDto.getImage().substring(22));
            EmployeeDto employeeDto = faceDetector.detectFace(imageBytes);
            return employeeDto;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
