package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.Repository.EmployeeRepository;
import com.aconex.FaceRecognition.model.Employee;
import com.aconex.FaceRecognition.representation.EmployeeDetailsDto;
import com.aconex.FaceRecognition.representation.EmployeeDto;
import com.aconex.FaceRecognition.representation.EmployeeRegisterDto;
import com.aconex.FaceRecognition.representation.RegistrationStatusDto;
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

        try {

            Employee employee = employeeRepository.findOne(personId);

            return dto(employee);
        }catch(Exception e){
            return new EmployeeDto();
        }
    }

    public RegistrationStatusDto registerEmployee(String employeePersonId,EmployeeRegisterDto employeeRegisterDto){

        try{

            employeeRepository.save(dto(employeePersonId,employeeRegisterDto));

        }catch (Exception e){
            return null;
        }

        return new RegistrationStatusDto("success");
    }
}