package com.feichai.test.circularDependency;

import org.springframework.stereotype.Component;

//@Component
public class A {
    B b;

    A(){

    }

    public void setB(B b) {
        this.b = b;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~A created.");
    }

}
