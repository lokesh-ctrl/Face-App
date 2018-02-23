package com.aconex.FaceRecognition.controller;


import com.aconex.FaceRecognition.representation.EmployeeDetailsDto;
import com.aconex.FaceRecognition.representation.EmployeeIdDto;
import com.aconex.FaceRecognition.services.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/getDetails")
public class CheckingEmployeeIdController {

    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    CheckingEmployeeIdController(EmployeeDetailsService employeeDetailsService){

        this.employeeDetailsService=employeeDetailsService;

    }

    @PostMapping(produces = APPLICATION_JSON_VALUE,consumes = APPLICATION_JSON_VALUE)
    EmployeeDetailsDto checkAndGetDetails(@RequestBody EmployeeIdDto employeeIdDto){

        try {
            return employeeDetailsService.checkAndGetEmployeeDetails(employeeIdDto.getEmployeeId());

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
