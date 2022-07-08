package com.codermy.myspringsecurityplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@SpringBootApplication
@EnableTransactionManagement//添加注解
public class MySpringsecurityPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringsecurityPlusApplication.class, args);
    }

}
