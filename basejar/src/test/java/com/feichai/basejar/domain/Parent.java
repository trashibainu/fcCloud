package com.feichai.basejar.domain;

public class Parent {
    public void show(){
        System.out.println("Parent.show()");
    }

    public void run(){
        show();
    }
}
