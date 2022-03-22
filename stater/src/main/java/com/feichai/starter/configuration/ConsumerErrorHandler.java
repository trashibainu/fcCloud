package com.feichai.starter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;

@Configuration
public class ConsumerErrorHandler {

    @Bean
    public ConsumerAwareErrorHandler consumerAwareErrorHandler(){

        return ((e, consumerRecord, consumer) -> {
            System.out.println("错误处理");
           return;
        });
    }
}
