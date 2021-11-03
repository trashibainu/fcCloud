package com.feichai.basejar.knowledge;


public class Single {
    private static Single single;

    private Single() {
    }

    public static Single getSingle() {
        synchronized (Single.class) {
            if (single != null) {
                single = new Single();
            }
        }
        return single;
    }
}


class Cat{
    private static final Cat cat=new Cat();

    private Cat(){

    }
    public static Cat getInstance(){
        return cat;
    }
}