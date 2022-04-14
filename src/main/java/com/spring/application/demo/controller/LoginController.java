package com.spring.application.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login-form";
    }
    @GetMapping("/access")
    public String access(){
        return "access-file";
    }

}

