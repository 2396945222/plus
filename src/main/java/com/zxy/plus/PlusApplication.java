package com.zxy.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.zxy.plus.dao")
@EnableAutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class PlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class, args);
    }

}
