package com.aconex.FaceRecognition.Repository;

import com.aconex.FaceRecognition.model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails,String> {

    @Override
    EmployeeDetails findOne(String eid);

}
