package com.feichai.starter.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/send/{message}")
    public void sendMessage(@PathVariable("message") String msg){

        kafkaTemplate.send("test",1,1l,"",msg).addCallback(sucess ->{
            System.out.println("发送成功");
        }, fail ->{
            System.out.println("发送失败");
        });


        kafkaTemplate.send("test", msg).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {

            }
        });
    }


    @GetMapping("/kafka/send/{message}")
    public void sendMessageWithTC(@PathVariable("message") String msg){
        // 声明事务：后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations -> {
            return operations.send("topic1", "test executeInTransaction");
        });

        // 不声明事务：后面报错但前面消息已经发送成功了
        kafkaTemplate.send("topic1","test executeInTransaction");
        throw new RuntimeException("fail");


    }
}
