package com.feichai.test.mybatis;

import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Process {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        sqlSession.selectMap("name","yuanjing");
        MapperProxy mapper = sqlSession.getMapper(MapperProxy.class);
    }
}
