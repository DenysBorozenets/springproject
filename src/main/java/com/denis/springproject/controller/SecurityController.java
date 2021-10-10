package com.denis.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/login")
    public String getLoginPage(){
       return "login";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }




}
