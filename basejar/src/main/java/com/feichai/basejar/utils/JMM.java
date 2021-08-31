package com.feichai.basejar.utils;

public class JMM {
    public static void main(String[] args) throws InterruptedException {
        Person person=new Person();

        new Thread(()->{
            System.out.println("AAA come in.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.add();
            System.out.println("person.age::"+person.age);
        },"AAA").start();

        while (person.age==10){
//            System.out.println("+++");
        }
        Thread.sleep(100);
        System.out.println("jmm is over.");
    }
}


class Person{
    volatile int age=10;

    public void add(){
        this.age=120;
    }
}

