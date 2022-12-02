package com.application.services.interfaces;

import com.application.entities.Product;
import com.application.enums.Category;

import java.util.List;

public interface ProductServiceInterface {

    Product addProduct(Product product);
    Product updateProduct(Product product, Integer productId);
    Product getProductById(Integer productId);
    List<Product> getProducts();
    List<Product> getProductsByCategory(Category category);

}
