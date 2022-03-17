package com.feichai.common;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacherTest {


    @Test
    public void macher(){
        String str = "[[[\"varianceType\",\"=\",\"L\"]],\"and\",[[\"ticketNoVarianceProcessingStatus\",\"=\",\"F\"]],\"and\",[[\"passengerCountVariance\",\"<>\",\"0\"],\"or\",[\"ticketNoVariance\",\">\",\"0\"],\"or\",[\"ticketNoVarianceProcessingCount\",\">\",\"0\"]]]";

        if(str.contains("varianceType")){
            Pattern p = Pattern.compile("\\[\\[\\\"varianceType\\\",\\\"=\\\",\\\"[A-Z]\\\"]],\\\"and\\\",");
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                System.out.println(group);
                str = str.replace(group, "");
                System.out.println(str);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        if(str.contains("ticketNoVarianceProcessingStatus")){
            Pattern p = Pattern.compile("\\[\\[\\\"ticketNoVarianceProcessingStatus\\\",\\\"=\\\",\\\"[A-Z]\\\"]],\\\"and\\\",");
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                System.out.println(group);
                str = str.replace(group, "");
                System.out.println(str);
            }
        }


    }
}
