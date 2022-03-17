package com.feichai.test.annotation;

public class Test {
    public static void main(String[] args) {
        test();
    }

    @Trashibainu(name = "hong", age = 1)
    static void test(){
        System.out.println(1+1);
    }
}
