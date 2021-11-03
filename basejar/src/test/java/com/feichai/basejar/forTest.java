package com.feichai.basejar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class forTest {
    List list = new ArrayList();

    @Test
    public void test(){
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));


    }
}
