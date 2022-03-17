package com.feichai.test.mybatis;

import org.apache.ibatis.cache.Cache;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfigin {

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setCacheEnabled(true);//设置二级缓存
                configuration.addInterceptor(new MybatisPlugin());
            }
        };
    }
}
