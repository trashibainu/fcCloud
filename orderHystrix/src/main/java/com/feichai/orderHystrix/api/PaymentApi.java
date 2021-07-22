package com.feichai.orderHystrix.api;

import com.feichai.orderHystrix.service.FallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "feichai-payment-service",fallback = FallbackHandler.class)
public interface PaymentApi {
    @GetMapping(value = "/work/status")
    String query();

    @GetMapping("/payment/ok")
    String ok();
    @GetMapping("/payment/timeout")
    String timeout();
}
