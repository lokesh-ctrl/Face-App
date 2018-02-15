package com.aconex.FaceRecognition.controller;

import com.aconex.FaceRecognition.representation.EmployeeRegisterDto;
import com.aconex.FaceRecognition.representation.RegistrationStatusDto;
import com.aconex.FaceRecognition.services.EmployeeRegisterService;
import com.aconex.FaceRecognition.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/register")
public class RegistrationController {

    private EmployeeRegisterService employeeRegisterService;

    @Autowired
    RegistrationController(EmployeeRegisterService employeeRegisterService){
        this.employeeRegisterService=employeeRegisterService;

    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    RegistrationStatusDto register(@RequestBody EmployeeRegisterDto employeeRegisterDto){

        System.out.println(employeeRegisterDto.getEmployeeDesignation());

        RegistrationStatusDto registrationStatusDto= employeeRegisterService.registerAndTrainImages(employeeRegisterDto);

        System.out.println(registrationStatusDto.getStatus());

        return registrationStatusDto;

    }
}