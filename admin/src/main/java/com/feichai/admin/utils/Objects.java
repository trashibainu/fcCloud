package com.feichai.admin.utils;

import com.feichai.admin.domain.MusicDTO;
import com.feichai.admin.web.vo.MusicVO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Objects {

    public static Map beanToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }



        return map;
    }

    public static Map beansToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();

        Class clazz = object.getClass();
        List<Field[]> fieldsList = new ArrayList<>();  // 保存属性对象数组到列表
        while (clazz != null) {  // 遍历所有父类字节码对象
            Field[] declaredFields = clazz.getDeclaredFields();  // 获取字节码对象的属性对象数组
            if (declaredFields.length > 0) {
                fieldsList.add(declaredFields);
            }

            clazz = clazz.getSuperclass();  // 获得父类的字节码对象
        }

        for (Field[] fields : fieldsList) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(object) != null) {
                    map.put(field.getName(), field.get(object));
                }
            }
        }

        return map;
    }






    public static void main(String[] args) throws IllegalAccessException {
        MusicVO musicDTO = new MusicVO();
            musicDTO.setAlbum("111");
            musicDTO.setSinger("23");
            musicDTO.setName("aka");
        Map map = beansToMap(musicDTO);
        System.out.println(map.toString());
    }
}
