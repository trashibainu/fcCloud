package com.feichai.basejar;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test(){
        String str="a,bb,ccc,dddd,eeeee";
        String st1r="a";

        String strs[]=st1r.split(",");
        System.out.println(JSONObject.toJSONString(strs));
    }
}
