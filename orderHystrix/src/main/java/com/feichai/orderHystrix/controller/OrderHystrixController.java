package com.feichai.orderHystrix.controller;

import com.feichai.orderHystrix.api.PaymentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController{
    @Resource
    private PaymentApi paymentApi;

    @GetMapping("/payment/ok")
    public String ok(){
        return paymentApi.ok();
    }
    @GetMapping("/payment/timeout")
    public String error(){
        return paymentApi.timeout();
    }

}
