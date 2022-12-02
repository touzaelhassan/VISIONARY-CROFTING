package com.application.entities;

import com.application.enums.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String reference;
    private String description;
    private Float price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Stock stock;

    @OneToMany(mappedBy = "product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<OrderItem> orderItems = new ArrayList<>();

    public Product() { }

    public Product(String name, String reference, String description, Float price, Integer quantity, Category category) {

        this.name = name;
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setReference(String reference) { this.reference = reference; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(Float price) { this.price = price; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setCategory(Category category) { this.category = category; }
    public void setStock(Stock stock) { this.stock = stock; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getReference() { return reference; }
    public String getDescription() { return description; }
    public Float getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public Category getCategory() { return category; }
    public Stock getStock() { return stock; }

}
