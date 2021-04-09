package com.feichai.order.controller;

import com.feichai.order.service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    Gson gson;


    @ResponseBody
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    public String queryOrderInfoById(@PathVariable("id") String id){
        return gson.toJson(orderService.queryOrderInfoById(id));
    }
}
