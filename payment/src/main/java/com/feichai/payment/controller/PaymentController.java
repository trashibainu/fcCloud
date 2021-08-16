package com.feichai.payment.controller;

import com.feichai.basejar.commons.CommonResult;
import com.feichai.basejar.entities.Order;
import com.feichai.payment.service.PaymentService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Resource
    Gson gson;

    @GetMapping("/select/{id}")
    public String select(@PathVariable String id){
        Order order=paymentService.select(id);
        return gson.toJson(CommonResult.success(order));
    }

    @GetMapping("/insert")
    public String select(Order order){
        return gson.toJson(CommonResult.success(paymentService.insert(order)));
    }
}
