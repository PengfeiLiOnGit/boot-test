package com.jony.boot5.boottest.controller;


import com.jony.boot5.boottest.entity.Ingredient;
import com.jony.boot5.boottest.entity.Ingredient.Type;

import com.jony.boot5.boottest.entity.Taco;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@Slf4j
@Log4j2
@RequestMapping("/design")
public class DesignController {

    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
//    @PatchMapping
//    @RequestMapping(method = {RequestMethod.GET,RequestMethod.DELETE})
    public String showDesign(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        for (Type type:Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
        }
        Taco taco = new Taco();
//        taco.setName("taco name");
        model.addAttribute("design",taco);
        return "design";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
