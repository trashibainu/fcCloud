package com.feichai.basejar.knowledge;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(() ->{
            lock.lock();
            try {
                System.out.println("A come in");
                TimeUnit.MINUTES.sleep(20);
            }catch (Exception e){

            }finally{
                lock.unlock();
            }
        },"A");



        new Thread(() ->{
            lock.lock();
            try {
                System.out.println("B come in");
                TimeUnit.MINUTES.sleep(20);
            }catch (Exception e){

            }finally{
                lock.unlock();
            }
        },"B");


        new Thread(() ->{
            lock.lock();
            try {
                System.out.println("C come in");
                TimeUnit.MINUTES.sleep(20);
            }catch (Exception e){

            }finally{
                lock.unlock();
            }
        },"C");

    }
}
