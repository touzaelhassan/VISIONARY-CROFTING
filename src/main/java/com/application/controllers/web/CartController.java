package com.application.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("cartControllerBean")
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public String showCart(){

        return "cart";

    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable Integer productId){

        return "redirect:/cart";

    }

}
