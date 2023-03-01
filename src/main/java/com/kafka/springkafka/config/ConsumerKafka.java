package com.kafka.springkafka.config;

import com.kafka.springkafka.model.MyCustomEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerKafka {

    @Bean
    public ConsumerFactory<String, MyCustomEvent> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configProps.put(JsonDeserializer.KEY_DEFAULT_TYPE, MyCustomEvent.class);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
       /* JsonDeserializer<MyCustomEvent> jsonDeserializer = new JsonDeserializer<>(MyCustomEvent.class);

        //jsonDeserializer.addTrustedPackages("com.kafkaconsumer.springbootkafkaconsumer.model.MyCustomEvent");
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);*/

        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactoryString() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      /*  configProps.put(JsonDeserializer.KEY_DEFAULT_TYPE, MyCustomEvent.class);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES,"*");*/
       /* JsonDeserializer<MyCustomEvent> jsonDeserializer = new JsonDeserializer<>(MyCustomEvent.class);

        //jsonDeserializer.addTrustedPackages("com.kafkaconsumer.springbootkafkaconsumer.model.MyCustomEvent");
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);*/

        return new DefaultKafkaConsumerFactory<>(configProps);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MyCustomEvent> employeeListener(){
        ConcurrentKafkaListenerContainerFactory<String, MyCustomEvent> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> employeeListenerStr(){
        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactoryString());
        return concurrentKafkaListenerContainerFactory;
    }
}
