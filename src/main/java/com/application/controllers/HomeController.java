package com.application.controllers;

import com.application.entities.Product;
import com.application.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("homeControllerBean")
public class HomeController {

    private ProductServiceInterface productServiceBean;

    @Autowired
    public HomeController(ProductServiceInterface productServiceBean) { this.productServiceBean = productServiceBean; }

    @GetMapping("/home")
    private String login(Model model){
        List<Product> products = productServiceBean.getProducts();
        model.addAttribute("products", products);
        return "index";
    }

}
