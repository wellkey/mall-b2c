package com.pzh.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/2 10:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
