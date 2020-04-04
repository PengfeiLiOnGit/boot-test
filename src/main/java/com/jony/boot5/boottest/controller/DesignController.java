package com.jony.boot5.boottest.controller;


import com.jony.boot5.boottest.dao.IngredientDao;
import com.jony.boot5.boottest.dao.TacoDao;
import com.jony.boot5.boottest.entity.Ingredient;
import com.jony.boot5.boottest.entity.Ingredient.Type;
import com.jony.boot5.boottest.entity.Order;
import com.jony.boot5.boottest.entity.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes({"order"})
public class DesignController {
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private TacoDao tacoDao;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model,HttpSession session) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientDao.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Taco design, Errors errors,
            @ModelAttribute Order order, HttpSession session, SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "design";
        }

//        order.addDesign(design);
        order.setCity("xuzhou");
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
