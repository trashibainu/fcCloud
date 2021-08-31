package com.feichai.message.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.feichai.basejar.commons.CommonResult;
import com.feichai.message.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public String byResource() {
        return CommonResult.success("byResource.OK").toString();
    }

    public String handleException(BlockException blockException){
        return CommonResult.failed("服务暂不可用."+blockException.getClass().getCanonicalName()).toString();
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl() {
        return CommonResult.success("byUrl.OK").toString();
    }

    @GetMapping("/customerHandler")
    @SentinelResource(value = "customerHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handler")
    public String customerHandler() {
        return CommonResult.success("customerHandler.OK").toString();
    }
}
