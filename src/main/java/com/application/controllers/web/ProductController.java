package com.application.controllers.web;

import com.application.entities.Product;
import com.application.enums.Category;
import com.application.services.classes.ProductServiceClass;
import com.application.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductServiceInterface productServiceBean;

    @Autowired
    public ProductController(ProductServiceClass productServiceBean) { this.productServiceBean = productServiceBean; }

    @GetMapping("/product/{productId}")
    public String showProduct(@PathVariable Integer productId, Model model){

        Product product = productServiceBean.getProductById(productId);
        model.addAttribute("product", product);

        return "product";

    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable Category category){ return productServiceBean.getProductsByCategory(category); }

    @PostMapping("/create")
    public Product addProduct(@RequestBody Product product){ return productServiceBean.addProduct(product); }

    @PutMapping("/update/{productId}")
    public Product addProduct(@RequestBody Product product, @PathVariable Integer productId){ return productServiceBean.updateProduct(product , productId); }

}
