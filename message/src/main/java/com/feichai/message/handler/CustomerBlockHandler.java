package com.feichai.message.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.feichai.basejar.commons.CommonResult;

public class CustomerBlockHandler {

    public static String handler(BlockException exception){
        return CommonResult.failed("CustomerBlockHandler.handler."+exception.getMessage()).toString();
    }

    public static String handlerOne(BlockException exception){
        return CommonResult.failed("CustomerBlockHandler.handlerOne."+exception.getMessage()).toString();
    }
}
