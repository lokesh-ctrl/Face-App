package com.aconex.FaceRecognition.controller;

import com.aconex.FaceRecognition.representation.FindFaceStatusDto;
import com.aconex.FaceRecognition.representation.ImageDto;
import com.aconex.FaceRecognition.services.PersonFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/controlImg")
public class ImageController {

    private PersonFaceService personFaceService;

    @Autowired
    ImageController(PersonFaceService personFaceService){
        this.personFaceService=personFaceService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public FindFaceStatusDto DetectFace(@RequestBody ImageDto imageDto) {

        try {

            byte[] imageBytes = Base64.getDecoder().decode(imageDto.getImage().substring(22));
            return personFaceService.FindFace(imageBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}