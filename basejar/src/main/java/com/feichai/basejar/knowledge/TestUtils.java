package com.feichai.basejar.knowledge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestUtils {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        lock.lock();

        lock.unlock();
    }
}
