package com.aconex.FaceRecognition.controller;

import com.aconex.FaceRecognition.representation.EmployeeDto;
import com.aconex.FaceRecognition.representation.FindFaceStatusDto;
import com.aconex.FaceRecognition.representation.ImageDto;
import com.aconex.FaceRecognition.representation.PersonImageDto;
import com.aconex.FaceRecognition.services.PersonFaceService;
import jdk.nashorn.internal.runtime.FindProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.aconex.FaceRecognition.services.FaceDetector;

@RestController
@RequestMapping("/controlImg")
public class ImageController {

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public FindFaceStatusDto DetectFace(@RequestBody ImageDto imageDto) {

        try {

            System.load("/home/manoj/Documents/Projects/Face-App/libs/libopencv_java320.so");

            byte[] imageBytes = Base64.getDecoder().decode(imageDto.getImage().substring(22));
            return PersonFaceService.FindFace(imageBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}