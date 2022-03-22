package com.feichai.starter.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {

    @KafkaListener(id = "consumer1", topics = {"test"},groupId = "group1", errorHandler = "consumerAwareErrorHandler",
            containerFactory = "containerFactory"
    )
    public void onMessage(ConsumerRecord<?,?> record){
        
    }


    //同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
    @KafkaListener(id = "consumer1",groupId = "felix-group",topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = { "0" }),
            @TopicPartition(topic = "topic2", partitions = "0",
                    partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
    }, errorHandler = "consumerAwareErrorHandler" ,containerFactory = "containerFactory")
    public void onMessage1(ConsumerRecord<?,?> record){

    }


    //批量消费
//    # 设置批量消费
//    spring.kafka.listener.type=batch
//    # 批量消费每次最多消费多少条消息
//    spring.kafka.consumer.max-poll-records=50
    @KafkaListener(id = "consumer1", topics = {"test"},groupId = "group1",
            errorHandler = "consumerAwareErrorHandler",
            containerFactory = "containerFactory")
    public void onMessage2(List<ConsumerRecord<?,?>> records){
        for (ConsumerRecord<?, ?> record : records) {

        }
    }
}
