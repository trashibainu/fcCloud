package com.feichai.test.threadLock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadLock {

    static int a = 1, b = 9;

    @GetMapping("/lock")
    public void show1() {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
    }

//    @GetMapping("/lock1")
//    public void show2() {
//        synchronized () {
//            System.out.println(SynAddRunalbe.a + SynAddRunalbe.b);
//        }
//    }

    @GetMapping("/lock2")
    public void show3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Integer.valueOf(DeadLock.a)){
                    System.out.println(DeadLock.b);
                }
            }
        }).start();
    }

    @GetMapping("/lock3")
    public void show4() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println(DeadLock.a);
            }
        }).start();
    }
    /**
     * 线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable {
        static int a, b;
        public SynAddRunalbe(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }


}
