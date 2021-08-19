package com.feichai.basejar.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("order")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;
    @NonNull
    private String orderId;
    private double orderAmount;
    @NonNull
    private String userId;
    private String createDate;
    private String updateDate;
}
