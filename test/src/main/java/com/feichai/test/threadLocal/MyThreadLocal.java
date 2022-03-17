package com.feichai.test.threadLocal;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class MyThreadLocal {

    static final ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        threadLocal.set(Thread.currentThread().getName());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());

                System.out.println("sfas::::::::::::"+threadLocal.get());
            }
        }).start();

        System.out.println(threadLocal.get());
    }
}
