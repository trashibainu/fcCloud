package com.feichai.test.circularDependency;

import org.springframework.stereotype.Component;

//@Component
public class B {
    A a;

    B(){

    }


    public void setA(A a) {
        this.a = a;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~B created.");
    }
}
