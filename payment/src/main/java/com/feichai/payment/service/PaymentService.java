package com.feichai.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentService {
    public String ok(){
        return "线程池："+Thread.currentThread()+"\t接口：Ok()";
    }


      //单独的fallback
//    @HystrixCommand(fallbackMethod = "timeout_handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
//    })
    @HystrixCommand
    public String timeout(){
        try {
            int a=10/0;
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread()+"\t接口：timeout()";
    }
    public String timeout_handler(){
        return "系统忙，请稍侯再试：\t当前线程："+Thread.currentThread();
    }



    //下面是全局fallback方法
    public String globalFallback(){
        return "系统忙，请稍侯再试!";
    }
}
