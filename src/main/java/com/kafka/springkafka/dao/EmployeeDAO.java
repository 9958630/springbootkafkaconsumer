package com.kafka.springkafka.dao;

import com.kafka.springkafka.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends MongoRepository<Employee,String> {
}
