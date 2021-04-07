package com.feichai.basejar.entities;

import com.sun.scenario.effect.impl.prism.PrImage;
import lombok.Data;

@Data
public class Order {
    private String id;
    private String orderId;
    private double orderAmount;
    private String userId;
    private String createTime;
    private String updateTime;
}
