package com.feichai.order.service.impl;

import com.feichai.basejar.commons.CommonResult;
import com.feichai.basejar.entities.Order;
import com.feichai.order.mapper.OrderMapper;
import com.feichai.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public CommonResult queryOrderInfoById(String id) {
        Order order=orderMapper.queryOrderInfoById(id);
        return CommonResult.success(order);
    }
}
