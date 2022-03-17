package com.feichai.test.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
//@Documented
//@Inherited
public @interface Trashibainu {
    String name() default "yuanjing";
    int age() default 0;
}
