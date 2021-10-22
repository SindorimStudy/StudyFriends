package com.study.friends.controller.user;

import com.study.friends.config.auth.LoginUser;
import com.study.friends.config.auth.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index(Model model,@LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("user",user.getName());
        }
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