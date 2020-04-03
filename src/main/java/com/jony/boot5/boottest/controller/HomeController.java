package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.entity.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session){
        session.setAttribute("user","normal");
        return "home";
    }

}
