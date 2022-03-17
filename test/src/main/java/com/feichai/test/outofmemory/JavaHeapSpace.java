package com.feichai.test.outofmemory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class JavaHeapSpace {

    @GetMapping("/test")
    public void show() {
        ArrayList<String> arrayList = new ArrayList<String>();
        while (true) {
            String demo = new String(UUID.randomUUID().toString());
            arrayList.add(demo);
        }
    }

}
