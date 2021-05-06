package com.feichai.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FeichaiAdminApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(FeichaiAdminApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  废柴开启   ლ(´ڡ`ლ)ﾞ  \n" +
                " .---------       ( (\n" +
                " |   ______|    ( (\n" +
                " |  |          ( (\n" +
                " |  ______    ( (\n" +
                " |  ______|  ( (\n" +
                " |  |         ( (\n" +
                " |  |           ( (\n" +
                " |  |             (_(\n" +
                " ");
    }
}
