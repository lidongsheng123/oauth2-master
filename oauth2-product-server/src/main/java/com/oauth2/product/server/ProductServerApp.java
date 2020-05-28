package com.oauth2.product.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/27 17:37
 */
@ComponentScan()
@EnableDiscoveryClient
@SpringBootApplication
public class ProductServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApp.class);
    }
}
