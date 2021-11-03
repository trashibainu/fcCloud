package com.feichai.test.circularDependency;

import javafx.application.Application;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ABtEST {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a",A.class);
        B b = context.getBean("b",B.class);
    }
}
