package com.oauth2.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/28 10:49
 */
@Configuration
@EnableWebSecurity  //开启security 过滤器链
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // spring 5.x 之后需要对密码进行加密 否则报 **There is no PasswordEncoder mapped for the id "null"*
        String password = createPasswordEncoder().encode("123456");  //加salt 算法

        System.out.println(password);

        auth.inMemoryAuthentication().withUser("admin").password(password)
                .authorities("ADMIN");  //此参数不能为空;
    }

    /**
     * 资源权限配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login/page")  //设置登录页面路径
                .and()
                .authorizeRequests()//认证请求
                .antMatchers("/login/page").permitAll() //对此处配置的路径不进行拦截
                .anyRequest().authenticated(); //所有访问本项目的请求都要通过身份认证;
    }

    /**
     * 对静态资源进行放行
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/dist/**", "/modules/**", "/plugins/**");
    }
}
