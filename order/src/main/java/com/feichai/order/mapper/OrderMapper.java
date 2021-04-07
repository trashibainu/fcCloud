package com.feichai.order.mapper;

import com.feichai.basejar.entities.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order queryOrderInfoById(String id);
}
