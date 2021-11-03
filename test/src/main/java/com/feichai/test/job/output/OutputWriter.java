package com.feichai.test.job.output;

import com.feichai.test.domain.SysMenu;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class OutputWriter implements ItemWriter<SysMenu> {

    @Override
    public void write(List<? extends SysMenu> list) throws Exception {
        list.forEach(system -> {
            System.out.println("-------"+system);
        });
    }
}
