package com.kafka.springkafka.mapper;

import com.kafka.springkafka.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = "spring")
public interface AccountMapper {
    Account modelToEntity(com.kafka.springkafka.model.Account account);

    List<Account> listModelToEntity(List<com.kafka.springkafka.model.Account> accounts);

}
