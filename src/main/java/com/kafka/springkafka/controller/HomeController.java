package com.kafka.springkafka.controller;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @KafkaListener(topics = "teststr",groupId = "group_id_1234",containerFactory = "employeeListenerStr")
    public void consumeStringKafkaMessage(@Payload String message){
        System.out.println("message :"+message);
    }
}
