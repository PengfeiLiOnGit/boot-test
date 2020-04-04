package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.entity.Country;
import com.jony.boot5.boottest.entity.Ingredient;
import com.jony.boot5.boottest.mapper.CountryMapper;
import com.jony.boot5.boottest.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    /**
     * JPA repository
     */
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping("/")
    public String home(HttpSession session){
//        session.setAttribute("user","normal");
//        JPA 查询
        List<Country> list = countryRepository.findAll();
//mybatis 查询
        List<Country> list1 = countryMapper.selectAll();
        return "home";
    }

}
