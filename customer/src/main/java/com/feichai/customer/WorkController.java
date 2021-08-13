package com.feichai.customer;

import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.sql.SQLException;

@Controller
@RequestMapping("/work")
@RefreshScope
public class WorkController {
    @Value("${server.url}")
    String url;
    @Value("${user.name}")
    String name;

    @Resource
    Gson gson;

    @Resource
    RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/status")
    public String work() throws SQLException {
        return "ok";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {

        return gson.toJson(CommonResult.success(new String[]{url, name}));
    }

    @ResponseBody
    @GetMapping("/query")
    public String query() {
        String str=restTemplate.getForObject("http://feichai-payment-service/payment/ok",String.class);
        return gson.toJson(CommonResult.success(str));
    }



}
