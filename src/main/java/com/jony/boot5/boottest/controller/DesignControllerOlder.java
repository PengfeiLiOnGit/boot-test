package com.jony.boot5.boottest.controller;


import com.jony.boot5.boottest.dao.IngredientDao;
import com.jony.boot5.boottest.dao.TacoDao;
import com.jony.boot5.boottest.entity.Ingredient;
import com.jony.boot5.boottest.entity.Ingredient.Type;
import com.jony.boot5.boottest.entity.Order;
import com.jony.boot5.boottest.entity.Taco;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
////@Slf4j
//@Log4j2
//@RequestMapping("/design")
////保存到session中
//@SessionAttributes("order")
public class DesignControllerOlder {

    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private TacoDao tacoDao;

    @ModelAttribute(name = "order")
    public Order order(){
        Order order = new Order();
        order.setName("test-name");
        order.setCity("xuzhou");
        return order;
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    //    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
//    @PatchMapping
//    @RequestMapping(method = {RequestMethod.GET,RequestMethod.DELETE})
//    public String showDesign(Model model){
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//                new Ingredient("SLSA", "Salsa", Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//        );
//        for (Type type:Ingredient.Type.values()) {
//            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
//        }
//        Taco taco = new Taco();
////        taco.setName("taco name");
//        model.addAttribute("design",taco);
//        return "design";
//    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//                new Ingredient("SLSA", "Salsa", Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//        );
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientDao.findAll().forEach((item)->{
            ingredients.add(item);
        });

        Type[] types = Type.values();
        for (Type type : types) {
//            添加model属性
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model, HttpSession session) {
        session.setAttribute("test","test");
        return "design";
    }

    @PostMapping
    /**
     * @ModelAttribute 标注order 来自模型，springmvc 不会进行注入
     */
    public String processDesign(@Valid @ModelAttribute("design")  Taco design,Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }
        order.addDesign(design);
//        log.info(design);
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
