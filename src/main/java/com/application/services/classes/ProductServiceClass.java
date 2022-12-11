package com.application.services.classes;

import com.application.entities.Product;
import com.application.entities.Stock;
import com.application.enums.Category;
import com.application.repositories.ProductRepository;
import com.application.repositories.StockRepository;
import com.application.services.interfaces.ProductServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceBean")
public class ProductServiceClass implements ProductServiceInterface {

   private ProductRepository productRepository;
   private StockRepository  stockRepository;

    public ProductServiceClass(ProductRepository productRepository, StockRepository stockRepository) {

        this.productRepository = productRepository;
        this.stockRepository = stockRepository;

    }

    @Override
    public Product addProduct(Product product) {

        Stock stock = stockRepository.findById(1).orElse(null);

        product.setStock(stock);

        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Product product , Integer productId) {

        Product DBProduct = productRepository.findById(productId).orElse(null);

        DBProduct.setName(product.getName());
        DBProduct.setReference(product.getReference());
        DBProduct.setDescription(product.getDescription());
        DBProduct.setCategory(product.getCategory());
        DBProduct.setPrice(product.getPrice());
        DBProduct.setQuantity(product.getQuantity());

        return productRepository.save(DBProduct);

    }

    @Override
    public Product getProductById(Integer productId) { return productRepository.findById(productId).orElse(null); }

    @Override
    public List<Product> getProducts() { return productRepository.findAll(); }

    @Override
    public List<Product> getProductsByCategory(Category category) { return productRepository.findByCategory(category); }

}
