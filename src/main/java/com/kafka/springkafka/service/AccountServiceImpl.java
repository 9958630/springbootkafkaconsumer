package com.kafka.springkafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.springkafka.dao.AccountDAO;
import com.kafka.springkafka.mapper.AccountMapper;
import com.kafka.springkafka.model.Account;
import com.kafka.springkafka.model.MyCustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountMapper mapper;

    public void saveAccountDetails(MyCustomEvent myCustomEvent){
        if( Objects.nonNull(myCustomEvent) && Objects.nonNull(myCustomEvent.getAccount())){
            try {
                System.out.println(new ObjectMapper().writeValueAsString(myCustomEvent));
            }catch (Exception exception){

            }
            accountDAO.save(mapper.modelToEntity(myCustomEvent.getAccount()));
        }
    }
}
