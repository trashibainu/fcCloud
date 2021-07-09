package com.feichai.orderConsul;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Resource
    DataSource dataSource;

    @Resource
    RestTemplate restTemplate;

    @Resource
    Gson gson;

    public static final String ORDER_REMOTE_URL="http://feichai-payment-service";

    @ResponseBody
    @GetMapping("/status")
    public String work() throws SQLException {
        Connection connection=dataSource.getConnection();
        String result="连接时间："+System.currentTimeMillis()+"，连接结果："+connection.getCatalog();
        connection.close();
        return result;
    }
    @ResponseBody
    @GetMapping("/test")
    public String test() {
        ResponseEntity<String> forEntity=restTemplate.getForEntity(ORDER_REMOTE_URL+"/work/status", String.class);
        return forEntity.getBody();
    }
}
