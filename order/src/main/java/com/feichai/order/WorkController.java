package com.feichai.order;

import com.feichai.basejar.commons.CommonResult;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {
    private transient final Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    DataSource dataSource;

//    @Resource
//    DiscoveryClient discoveryClient;
    @Resource
    Gson gson;

    @ResponseBody
    @RequestMapping("/status")
    public String work() throws SQLException {
        Connection connection=dataSource.getConnection();
        String result="连接时间："+System.currentTimeMillis()+"，连接结果："+connection.getCatalog();
        connection.close();
        return result;
    }

//    @ResponseBody
//    @RequestMapping("/discovery")
//    public String discovery() throws SQLException {
//        List<String> list=discoveryClient.getServices();
//        log.info("getServices:{}",gson.toJson(list));
//        List<ServiceInstance> instancesList=discoveryClient.getInstances("FEICHAI-ORDER-SERVICE");
//        log.info("getInstances:{}",gson.toJson(instancesList));
//        return gson.toJson(CommonResult.success(list,instancesList));
//    }

}
