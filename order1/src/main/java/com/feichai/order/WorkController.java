package com.feichai.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Resource
    DataSource dataSource;

    @ResponseBody
    @RequestMapping("/status")
    public String work() throws SQLException {
        Connection connection=dataSource.getConnection();
        String result="连接时间："+System.currentTimeMillis()+"，连接结果："+connection.getCatalog();
        connection.close();
        return result;
    }
}
