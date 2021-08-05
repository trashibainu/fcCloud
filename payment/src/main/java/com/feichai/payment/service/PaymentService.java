package com.feichai.payment.service;

import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentService {
    @Resource
    Gson gson;


    public String ok(){
        return "线程池："+Thread.currentThread()+"\t接口：Ok()";
    }

    /**
     * 服务降级
     * @return
     */
      //单独的fallback
//    @HystrixCommand(fallbackMethod = "timeout_handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
//    })
    @HystrixCommand()
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





    /**
     * 服务熔断
     * @return
     */
    @HystrixCommand(fallbackMethod = "Handler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="20"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="50"),//失败率达到多少后跳闸
    })
    public String messi(int num){
        if (num>0) {
            return "调用成功：" + UUID.randomUUID().toString();
        }else{
            throw new RuntimeException("num-----");
        }
    }

    public String Handler(int num){
        return "Num("+num+") 不能为负数";
    }
}
