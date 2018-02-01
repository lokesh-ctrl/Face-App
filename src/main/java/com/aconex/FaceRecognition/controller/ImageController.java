package com.aconex.FaceRecognition.controller;

import com.aconex.FaceRecognition.model.Employee;
import com.aconex.FaceRecognition.representation.EmployeeDto;
import com.aconex.FaceRecognition.representation.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.aconex.FaceRecognition.services.FaceDetector;


@RestController
@RequestMapping("/controlImg")
public class ImageController {

    private FaceDetector faceDetector;

    @Autowired
    public ImageController(FaceDetector faceDetector){

        this.faceDetector=faceDetector;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public EmployeeDto recognizeFace(@RequestBody ImageDto imageDto){

        try {

            byte[] imageBytes = Base64.getDecoder().decode(imageDto.getImage().substring(22));
            EmployeeDto employeeDto=faceDetector.detectFace(imageBytes);
            System.out.println(employeeDto.getName());
            return employeeDto;


        }catch(Exception e){
                e.printStackTrace();
        }
        return null;
    }
}