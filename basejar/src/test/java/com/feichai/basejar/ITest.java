package com.feichai.basejar;

import com.feichai.basejar.domain.Child;
import com.feichai.basejar.domain.Women;
import org.junit.Test;

public class ITest {

    @Test
    public void test(){
        Child child=new Child();
        child.run();
    }


    @Test
    public void test1(){
        Women women=new Women();
        women.think();
        women.speak();
    }
}
