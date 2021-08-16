package com.feichai.payment.controller;

import com.feichai.payment.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    TestService testService;

    @GetMapping("/payment/ok")
    public String ok(){
        return testService.ok();
    }
    @GetMapping("/payment/timeout")
    public String error(){
        return testService.timeout();
    }

}
