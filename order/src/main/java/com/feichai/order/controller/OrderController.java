package com.feichai.order.controller;

import com.feichai.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    public String queryOrderInfoById(@PathVariable("id") String id){

        return orderService.queryOrderInfoById(id).toString();
    }
}
