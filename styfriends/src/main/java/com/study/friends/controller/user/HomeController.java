package com.study.friends.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
    @RequestMapping(value="/signin")
    public String signin() {
        return "Signin";
    }
    
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

}