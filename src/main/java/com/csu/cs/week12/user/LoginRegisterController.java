package com.csu.cs.week12.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping()//(path = "api/v1/login/")
public class LoginRegisterController {

    @PostMapping(value = "action_login", params = "login")
    public void login(@RequestParam Map<String, String> params) {
        for (String key : params.keySet()) {


            System.out.println("key:" + params.get(key) );
        }
    }

    @PostMapping(value = "action_login", params = "register")
    public String register(@RequestParam Map<String, String> params) {
        for (String key : params.keySet()) {


            System.out.println("key:" + params.get(key) );
        }
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register.html");
        return modelAndView;*/
        return "/register.html";
    }
}
