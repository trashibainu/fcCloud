package com.feichai.orderHystrix.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "FEICHAI-PAYMENT-SERVICE")
public interface PaymentApi {
    @GetMapping(value = "/work/status")
    String query();

    @GetMapping("/payment/ok")
    public String ok();
    @GetMapping("/payment/timeout")
    public String timeout();
}
