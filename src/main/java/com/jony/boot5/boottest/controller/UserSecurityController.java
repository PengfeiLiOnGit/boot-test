package com.jony.boot5.boottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class UserSecurityController {
    @GetMapping
    public String toSecurity(){
        return "user_security";
    }
}
