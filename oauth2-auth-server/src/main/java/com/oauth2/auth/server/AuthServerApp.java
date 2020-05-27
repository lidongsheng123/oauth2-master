package com.oauth2.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/27 17:22
 */
@ComponentScan(basePackages = {"com.oauth2.auth.server"})
@EnableDiscoveryClient
@SpringBootApplication
public class AuthServerApp {
    public static void main(String[] args) {

        SpringApplication.run(AuthServerApp.class);
    }
}
