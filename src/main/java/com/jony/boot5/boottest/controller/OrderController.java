package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.dao.OrderDao;
import com.jony.boot5.boottest.entity.Order;
import com.jony.boot5.boottest.util.OrderProps;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

@Log4j2
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
//不能声明多个properties
//@ConfigurationProperties("taco.orders")
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    /**
     * 注入props 属性
     */
    private OrderProps props;

    @GetMapping
    public String order() {
        return "home";
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
//        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, HttpSession session, @SessionAttribute("order") Order sessionOrder) {
//        if(errors.hasErrors()){
//            return "orderForm";
//        }

//        清空session
//        orderDao.save(order);
        sessionStatus.setComplete();
        return "redi  b[nhect:/";
    }

//    @PostMapping
//    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, HttpSession session, @SessionAttribute("order") Order sessionOrder) {
////        if(errors.hasErrors()){
////            return "orderForm";
////        }
//
////        清空session
//        sessionStatus.setComplete();
//        return "redirect:/";
//    }

//    @PostMapping
//    public String processOrder(@Valid Order order1,Errors errors, SessionStatus sessionStatus,HttpSession session,@ModelAttribute("order") Order order ){
////        if(errors.hasErrors()){
////            return "orderForm";
////        }
//
////        清空session
//        sessionStatus.setComplete();
//        return "redirect:/";
//    }
}
