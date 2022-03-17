package com.feichai.test.annotation;

public interface New {
    default int sub(int x, int y) {
        return x - y;
    }

    public static int subs(int a, int b) {
        return a - b;
    }
}
