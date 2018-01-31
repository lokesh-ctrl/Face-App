package com.aconex.FaceRecognition.Repository;

import com.aconex.FaceRecognition.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String >{
    @Override
    Employee findOne (String personId);

    Employee save (Employee employee);


}
