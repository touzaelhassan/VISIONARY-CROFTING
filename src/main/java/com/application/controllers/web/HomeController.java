package com.application.controllers.web;

import com.application.entities.Product;
import com.application.services.interfaces.ProductServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ProductServiceInterface productServiceBean;

    @Autowired
    public HomeController(ProductServiceInterface productServiceBean) { this.productServiceBean = productServiceBean; }

    @GetMapping("home")
    private String login(Model model, HttpSession httpSession){

        Integer id = (Integer) httpSession.getAttribute("id");
        String name = (String) httpSession.getAttribute("name");
        String email = (String) httpSession.getAttribute("email");

        List<Product> products = productServiceBean.getProducts();

        model.addAttribute("name", name);
        model.addAttribute("products", products);

        return "index";

    }

}
