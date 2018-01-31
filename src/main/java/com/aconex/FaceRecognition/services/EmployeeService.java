package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.Repository.EmployeeRepository;
import com.aconex.FaceRecognition.model.Employee;
import com.aconex.FaceRecognition.representation.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.FaceRecognition.services.ObjectConverter.dto;
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public EmployeeDto getPersonDetails(String personId){

        Employee employee= employeeRepository.findOne(personId);

        return dto(employee);
    }
}
