package com.feichai;

public class test {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 10;
        Integer ia = 1;
//        System.out.println(a += b *= c -= d += b);
        String str = null;
        try {
            str = (1/0)+"";
        }catch (Exception e  ){
            System.out.println(e.getMessage());;
        }
        System.out.println(str);
    }
}


