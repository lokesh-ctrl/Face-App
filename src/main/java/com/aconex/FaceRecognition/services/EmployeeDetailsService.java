package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.Repository.EmployeeDetailsRepository;
import com.aconex.FaceRecognition.model.EmployeeDetails;
import com.aconex.FaceRecognition.representation.EmployeeDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.FaceRecognition.services.ObjectConverter.dto;



@Service
public class EmployeeDetailsService {


    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    EmployeeDetailsService(EmployeeDetailsRepository employeeDetailsRepository){

        this.employeeDetailsRepository=employeeDetailsRepository;

    }



    public EmployeeDetailsDto checkAndGetEmployeeDetails(String eId){

        try {
            EmployeeDetails employeeDetails=employeeDetailsRepository.findOne(eId);

            return dto(employeeDetails);



        }catch(Exception e){

            EmployeeDetailsDto employeeDetailsDto=new EmployeeDetailsDto();

            employeeDetailsDto.setStatus("fail");

            return employeeDetailsDto;

        }
    }

}
