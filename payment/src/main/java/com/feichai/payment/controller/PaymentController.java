package com.feichai.payment.controller;

import com.feichai.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/ok")
    public String ok(){
        return paymentService.ok();
    }
    @GetMapping("/payment/timeout")
    public String error(){
        return paymentService.timeout();
    }

    @GetMapping("/payment/messi/{num}")
    public String messi(@PathVariable int num){
        return paymentService.messi(num);
    }

}
