package com.feichai.test.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MongodbController {

    @Autowired
    MongodbDao mongodbDao;

    @GetMapping(value="/test1")
    public void saveTest() throws Exception {
        MongoTest mgtest=new MongoTest();
        mgtest.setId(UUID.randomUUID().toString().replaceAll("-",""));
        mgtest.setAge(33);
        mgtest.setName("ceshi");
        mongodbDao.saveTest(mgtest);
    }

    @GetMapping(value="/test2")
    public MongoTest findTestByName(){
        MongoTest mgtest= mongodbDao.findTestByName("ceshi");
        System.out.println("mgtest is "+mgtest);
        return mgtest;
    }

    @GetMapping(value="/test3")
    public void updateTest(){
        MongoTest mgtest=new MongoTest();
        mgtest.setAge(44);
        mgtest.setName("ceshi2");
        mongodbDao.updateTest(mgtest);
    }

    @GetMapping(value="/test4/{id}")
    public void deleteTestById(@PathVariable("id") String id){
        mongodbDao.deleteTestById(id);
    }


}
