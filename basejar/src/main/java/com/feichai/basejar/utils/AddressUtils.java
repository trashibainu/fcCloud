package com.feichai.basejar.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressUtils {

    public static void main(String[] args) {
        System.out.println(resolution("湖北省武汉市洪山区"));
        System.out.println(resolution("四川省阿坝自治州甘孜县"));
        System.out.println(resolution("北京市东城区"));
        System.out.println(resolution("四川省成都市"));

    }

        /**
         * 解析地址
         * @author lin
         * @param address
         * @return
         */
        public static Map<String,String> resolution(String address){
            String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县|.*?区)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?";
            Matcher m= Pattern.compile(regex).matcher(address);
            String province=null,city=null,county=null;
            Map<String,String> row=null;
            while(m.find()){
                row=new LinkedHashMap<String,String>();
                province=m.group("province");
                row.put("province", province==null?null:province.trim());
                city=m.group("city");
                row.put("city", city==null?null:city.trim());
                county=m.group("county");
                row.put("county", county==null?null:county.trim());
            }
            if(row==null){
                row=new LinkedHashMap<String,String>();
            }
            return row;
        }


        /**
         * 解析地址
         * @author lin
         * @param address
         * @return
         */
        public static Map<String,String> resolutionNew(String address){
            String pattern = ".+?(省|市|自治区|自治州|县|区)";
            String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?";


            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(address);
            System.out.println(m.groupCount());
            for (int i = 0; i < m.groupCount() + 1; i++) {
                System.out.println("分组" + i + ":" + m.group(i));
            }

            return null;
        }




}
