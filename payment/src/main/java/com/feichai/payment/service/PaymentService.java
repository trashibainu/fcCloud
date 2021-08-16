package com.feichai.payment.service;

import com.feichai.basejar.entities.Order;
import com.feichai.payment.mapper.OrderMapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentService {
    @Resource
    OrderMapper<Order> iOrderMapper;

    public Order select(String id){
        return iOrderMapper.selectById(id);
    }

    public int insert(Order order){
        String uuid=UUID.randomUUID().toString();
        order.setOrderId(uuid.replaceAll("-",""));
        order.setUserId("100");
        return iOrderMapper.insert(order);
    }
}
