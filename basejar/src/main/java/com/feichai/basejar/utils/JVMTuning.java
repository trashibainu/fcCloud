package com.feichai.basejar.utils;

import java.util.UUID;

public class JVMTuning {
    public static void main(String[] args) {
//        byte[] bytes=new byte[40 * 1024 * 1024];
        long maxMemory=Runtime.getRuntime().maxMemory();
        long totalMemory=Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx: MAX_MEMORY: "+maxMemory/1024/1024 +"MB");
        System.out.println("-Xms: TOTAL_MEMORY: "+totalMemory/1024/1024 +"MB");


        while(true){
            String str="STR_";
            str+= UUID.randomUUID().toString();
        }
    }
}
