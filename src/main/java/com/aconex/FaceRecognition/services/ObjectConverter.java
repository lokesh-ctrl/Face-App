package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.model.Employee;
import com.aconex.FaceRecognition.representation.EmployeeDto;

public class ObjectConverter {

    public static EmployeeDto dto(Employee employee){
        return new EmployeeDto(employee.getEmployeeId(),employee.getName(),employee.getDesignation(),employee.getIsAdmin());
    }
}
