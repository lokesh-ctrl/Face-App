package com.aconex.FaceRecognition.services;

import com.aconex.FaceRecognition.representation.EmployeeRegisterDto;
import com.aconex.FaceRecognition.representation.RegistrationStatusDto;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegisterService {

    private FaceAPIServices faceApiServices;
    private EmployeeService employeeService;

    @Autowired
    EmployeeRegisterService(EmployeeService employeeService, FaceAPIServices faceApiServices){

        this.employeeService=employeeService;
        this.faceApiServices = faceApiServices;
    }

    public RegistrationStatusDto registerAndTrainImages(EmployeeRegisterDto employeeRegisterDto){

        HttpEntity httpEntity=faceApiServices.createPersonRequestToFaceAPI(employeeRegisterDto.getEmployeeName(),employeeRegisterDto.getEmployeeDesignation());
        try {
            //System.out.println("\n\n\n" + EntityUtils.toString(httpEntity) + "\n\n\n");

            String employeePersonId=HttpEntityToJsonParserService.getRegPersonId(EntityUtils.toString(httpEntity));

            System.out.println("\n\n\n"+employeePersonId+"\n\n\n");

            EntityUtils.consume(httpEntity);

            faceApiServices.addImagesToPerson(employeePersonId,employeeRegisterDto.getEmployeeImages());

            return employeeService.registerEmployee(employeePersonId,employeeRegisterDto);

        }catch(Exception e){e.printStackTrace();}
        return null;
    }

}
