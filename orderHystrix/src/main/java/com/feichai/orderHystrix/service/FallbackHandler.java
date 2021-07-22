package com.feichai.orderHystrix.service;

import com.feichai.orderHystrix.api.PaymentApi;
import org.springframework.stereotype.Component;

@Component
public class FallbackHandler implements PaymentApi{
    @Override
    public String query() {
        return "系统错误query，请重试！";
    }

    @Override
    public String ok() {
        return "系统错误ok，请重试！";
    }

    @Override
    public String timeout() {
        return "系统错误timeout，请重试！";
    }
}
