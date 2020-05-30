package com.oauth2.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/28 15:47
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.oauth2.security.*"})
public class SecurityWebApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWebApp.class);
    }
}
