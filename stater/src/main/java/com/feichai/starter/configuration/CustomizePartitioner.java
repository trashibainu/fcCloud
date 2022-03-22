package com.feichai.starter.configuration;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

//在生产者配置指定自定义分区
//spring.kafka.producer.properties.partitioner.class = com.feichai.starter.configuration.CustomizePartitioner
public class CustomizePartitioner implements Partitioner {

    // 自定义分区规则(这里假设全部发到0号分区)
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
