package com.feichai.test.springbatch.output;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutputWriter implements ItemWriter<Object> {

    @Override
    public void write(List<? extends Object> list) throws Exception {
        list.forEach(system -> {
            System.out.println("-------"+system);
        });
    }
}
