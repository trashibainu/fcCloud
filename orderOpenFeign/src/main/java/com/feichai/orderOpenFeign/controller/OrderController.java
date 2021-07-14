package com.feichai.orderOpenFeign.controller;

import com.feichai.orderOpenFeign.api.PaymentApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    PaymentApi paymentApi;
    @GetMapping("/work/status")
    public String query(){
        return paymentApi.query();
    }
}
