package com.feichai.basejar.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestUtils {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        lock.lock();

        lock.unlock();
    }
}
