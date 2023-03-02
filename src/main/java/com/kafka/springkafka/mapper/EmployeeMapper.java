package com.kafka.springkafka.mapper;

import com.kafka.springkafka.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = "spring")
public interface EmployeeMapper {

    Employee modelToEntity(com.kafka.springkafka.model.Employee employee);

    List<Employee> listModelToEntity(List<com.kafka.springkafka.model.Employee> employees);
}
