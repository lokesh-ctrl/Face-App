package com.aconex.FaceRecognition.repository;


import com.aconex.FaceRecognition.Repository.EmployeeRepository;
import com.aconex.FaceRecognition.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void WhenFindByPersonId_thenReturnEmployee(){
        employeeRepository.save(new Employee("f2e7b3d3-ab7c-4bbc-ad45-0fd46883e34e", null, "Siva Prasad Raju", null,1));

        Employee employee =employeeRepository.findOne("f2e7b3d3-ab7c-4bbc-ad45-0fd46883e34e");

        assertEquals("Siva Prasad Raju", employee.getName());
    }


}
