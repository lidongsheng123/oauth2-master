package com.oauth2.security.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：Mr.Li
 * @date ：Created in 2020/5/28 14:02
 */
@Controller
public class controller {

    @RequestMapping("/login/page")
    public String toLogin() {
        return "login";
    }
}
