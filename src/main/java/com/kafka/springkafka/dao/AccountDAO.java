package com.kafka.springkafka.dao;

import com.kafka.springkafka.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends MongoRepository<Account, String> {
}
