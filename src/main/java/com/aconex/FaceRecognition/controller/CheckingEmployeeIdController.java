package com.aconex.FaceRecognition.controller;


import com.aconex.FaceRecognition.representation.EmployeeDetailsDto;
import com.aconex.FaceRecognition.representation.EmployeeIdDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/getDetails")
public class CheckingEmployeeIdController {

    @PostMapping(produces = APPLICATION_JSON_VALUE,consumes = APPLICATION_JSON_VALUE)
    EmployeeDetailsDto checkAndGetDetails(@RequestBody EmployeeIdDto employeeIdDto){




        return null;
    }





}
