package com.feichai.payment.configuration;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfiguration {

    /**
     * 原因是默认容器默认注入了了Mybatis的SqlSessionFactory而没有使用MybatisPlus的MybatisSqlSessionFactoryBean
     * <p>
     * <p>
     * 将SqlSessionFactory配置为MybatisPlus的MybatisSqlSessionFactoryBean
     *
     * @param dataSource 默认配置文件中的数据源
     * @return MybatisSqlSessionFactoryBean
     */
    @Bean("mpSqlSessionFactory")
    public MybatisSqlSessionFactoryBean setSqlSessionFactory(DataSource dataSource) {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        // 设置数据源
        bean.setDataSource(dataSource);
        // 简化PO的引用
        bean.setTypeAliasesPackage("com.xhiteam.usercenter.serve.model.po");
        // 设置全局配置
        bean.setGlobalConfig(this.globalConfig());
        return bean;
    }

    /**
     * 设置全局配置
     *
     * @return 全局配置
     */
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // 设置逻辑删除字段
        dbConfig.setLogicDeleteField("deleted");
        // 设置更新策略
        dbConfig.setUpdateStrategy(FieldStrategy.NOT_EMPTY);
        globalConfig.setDbConfig(dbConfig);
        return globalConfig;
    }

}