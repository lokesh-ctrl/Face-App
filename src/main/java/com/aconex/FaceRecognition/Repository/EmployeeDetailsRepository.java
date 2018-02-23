package com.aconex.FaceRecognition.Repository;

import com.aconex.FaceRecognition.model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails,String> {

    @Override
    EmployeeDetails findOne(String eid);

}
