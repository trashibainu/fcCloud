package com.feichai.test.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 完成插件的签名：告诉Mybatis拦截哪些个对象的哪个方法，重载的哪个方法
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)
})
public class MybatisPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
