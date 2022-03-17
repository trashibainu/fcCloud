package com.feichai.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    @Test
    public void to() {

        List<Person> list = new ArrayList();
        list.add(new Person("yuanjing", 1));
        list.add(new Person("ye", 3));
        list.add(new Person(null, 6));

        list.stream().filter(person -> person.getName() != null && person.getName().equals("ye"));
//        list.forEach(person -> {
//            if (person.getName() == null){
//                list.remove(person);
//            }
//        });
        list.removeIf(person -> person.getName() != null);
        System.out.println(list);
    }
}
