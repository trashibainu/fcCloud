package com.feichai.orderzk;

import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/work")
public class WorkController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    Gson gson;

    @RequestMapping("/test")
    public String Test(){
        return gson.toJson(CommonResult.success(serverPort));
    }
}
