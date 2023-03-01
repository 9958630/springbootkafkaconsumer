package com.kafka.springkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.springkafka.model.Employee;
import com.kafka.springkafka.model.MyCustomEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmployeeController {

    @KafkaListener(topics = "testobj",groupId = "group_id_123456",containerFactory = "employeeListener")
    public void consumeEmployeeObject(@Payload MyCustomEvent myCustomEvent) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(myCustomEvent));
        System.out.println(myCustomEvent);
    }
}
