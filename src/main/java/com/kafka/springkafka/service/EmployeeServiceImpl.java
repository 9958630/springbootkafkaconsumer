package com.kafka.springkafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.springkafka.dao.EmployeeDAO;
import com.kafka.springkafka.mapper.EmployeeMapper;
import com.kafka.springkafka.model.MyCustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeMapper mapper;

    public void saveEmployeeDetails(MyCustomEvent myCustomEvent){
        if(Objects.nonNull(myCustomEvent) && Objects.nonNull(myCustomEvent.getEmployee())){
            try {
                System.out.println(new ObjectMapper().writeValueAsString(myCustomEvent));
            }catch (Exception exception){

            }
            employeeDAO.save(mapper.modelToEntity(myCustomEvent.getEmployee()));
        }
    }
}
