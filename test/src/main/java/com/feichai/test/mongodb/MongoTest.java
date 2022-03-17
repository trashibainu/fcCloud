package com.feichai.test.mongodb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MongoTest {
    private String id;
    private Integer age;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime = new Date();
}
