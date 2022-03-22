package com.feichai.starter.configuration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//默认情况下，当消费者项目启动的时候，监听器就开始工作，监听消费发送到指定topic的消息，
// 那如果我们不想让监听器立即工作，想让它在我们指定的时间点开始工作，或者在我们指定的时间点停止工作，该怎么处理呢
@EnableScheduling
@Component
public class ConsumerTimer {

        /**
         * @KafkaListener注解所标注的方法并不会在IOC容器中被注册为Bean，
         * 而是会被注册在KafkaListenerEndpointRegistry中，
         * 而KafkaListenerEndpointRegistry在SpringIOC中已经被注册为Bean
         **/
        @Autowired
        private KafkaListenerEndpointRegistry registry;

        @Autowired
        private ConsumerFactory consumerFactory;

        // 监听器容器工厂(设置禁止KafkaListener自启动)
        @Bean
        public ConcurrentKafkaListenerContainerFactory delayContainerFactory() {
            ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
            container.setConsumerFactory(consumerFactory);
            //禁止KafkaListener自启动
            container.setAutoStartup(false);
            return container;
        }

        // 定时启动监听器
        @Scheduled(cron = "0 42 11 * * ? ")
        public void startListener() {
            System.out.println("启动监听器...");
            // "timingConsumer"是@KafkaListener注解后面设置的监听器ID,标识这个监听器
            if (!registry.getListenerContainer("timingConsumer").isRunning()) {
                registry.getListenerContainer("timingConsumer").start();
            }
            //registry.getListenerContainer("timingConsumer").resume();
        }

        // 定时停止监听器
        @Scheduled(cron = "0 45 11 * * ? ")
        public void shutDownListener() {
            System.out.println("关闭监听器...");
            registry.getListenerContainer("timingConsumer").pause();
        }

}
