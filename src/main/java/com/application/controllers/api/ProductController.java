package com.application.controllers.api;

import com.application.entities.Product;
import com.application.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceInterface productServiceBean;

    @Autowired
    public ProductController(ProductServiceInterface productServiceBean) { this.productServiceBean = productServiceBean; }

    @GetMapping("/")
    public List<Product> getProducts(){
        return productServiceBean.getProducts();
    }

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId, Model model){ return  productServiceBean.getProductById(productId); }

}
