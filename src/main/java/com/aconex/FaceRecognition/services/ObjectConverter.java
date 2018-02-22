package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.model.Employee;
import com.aconex.FaceRecognition.representation.EmployeeDto;
import com.aconex.FaceRecognition.representation.EmployeeRegisterDto;

public class ObjectConverter {

    public static EmployeeDto dto(Employee employee){
        return new EmployeeDto(employee.getEmployeeId(),employee.getName(),employee.getDesignation(),employee.getIsAdmin());
    }

    public static Employee dto(String personid,EmployeeRegisterDto employeeRegisterDto){

        return new Employee(personid,employeeRegisterDto.getEmployeeId(),employeeRegisterDto.getEmployeeName(),employeeRegisterDto.getEmployeeDesignation(),0);
    }
}
