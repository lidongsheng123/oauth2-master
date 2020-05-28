package com.oauth2.security.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/28 10:49
 */
@Configuration
@EnableWebSecurity  //开启security 过滤器链
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 认证管理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /**
     * 资源权限配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()//认证请求
                .anyRequest().authenticated(); //所有访问本项目的请求都要通过身份认证;
    }
}
