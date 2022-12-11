package com.application.controllers;

import com.application.entities.Product;
import com.application.enums.Category;
import com.application.services.classes.ProductServiceClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    ProductServiceClass productServiceClass;

    public ProductController(ProductServiceClass productServiceClass) { this.productServiceClass = productServiceClass; }

    @GetMapping("/products")
    public String  getProducts(Model model){

      List<Product> products =  productServiceClass.getProducts();
      model.addAttribute("products", products);
      return "products";

    }

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId){ return productServiceClass.getProductById(productId); }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable Category category){ return productServiceClass.getProductsByCategory(category); }

    @PostMapping("/create")
    public Product addProduct(@RequestBody Product product){ return productServiceClass.addProduct(product); }

    @PutMapping("/update/{productId}")
    public Product addProduct(@RequestBody Product product, @PathVariable Integer productId){ return productServiceClass.updateProduct(product , productId); }

}
