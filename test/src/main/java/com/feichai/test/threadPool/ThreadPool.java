package com.feichai.test.threadPool;


import lombok.SneakyThrows;
import lombok.Synchronized;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPool {
//    1.corePoolSize：核心线程数,决定添加的任务是开辟新的线程执行还是放到workQueue任务队列
//    2.maximumPoolSize：最大线程数量，根据你使用的workQueue队列类型，决定线程池开辟的最大线程数量
//    3.keepAliveTime：当线程池中空闲数量超过corPoolSize时，多余的线程会在多长时间内被销毁
//    4.TimeUnit unit：keepAliveTime的时间单位
//    5.BlockingQueue<Runnable> workQueue：任务队列，被添加到线程池中，但尚未被执行的任务，它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列
//    6.ThreadFactory threadFactory：线程工厂，用于创建线程，一般默认即可
//    7.RejectExecutionHandler handler：拒绝策略：当任务太多来不及处理时，如何拒绝任务



    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1,
            2,
            1000000l,
            TimeUnit.SECONDS,
//            new SynchronousQueue<>(),
//            new ArrayBlockingQueue<>(5),
//            new LinkedBlockingDeque<>(5),
            new PriorityBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            });

        }
    }
}
