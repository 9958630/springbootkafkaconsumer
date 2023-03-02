package com.kafka.springkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.springkafka.model.Employee;
import com.kafka.springkafka.model.MyCustomEvent;
import com.kafka.springkafka.service.AccountServiceImpl;
import com.kafka.springkafka.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private AccountServiceImpl accountService;

    @KafkaListener(topics = "testobj",groupId = "group_id_1234567",containerFactory = "employeeListener")
    public void consumeEmployeeObject(@Payload MyCustomEvent myCustomEvent) throws JsonProcessingException {
        if(Objects.nonNull(myCustomEvent) && Objects.nonNull(myCustomEvent.getEmployee()))
        employeeService.saveEmployeeDetails(myCustomEvent);
        if(Objects.nonNull(myCustomEvent) && Objects.nonNull(myCustomEvent.getAccount()))
        accountService.saveAccountDetails(myCustomEvent);
    }
}
