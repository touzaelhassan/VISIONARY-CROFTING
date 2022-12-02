package com.application.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    private Float price;
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    public OrderItem() { }

    public OrderItem(String reference, Float price, Integer quantity) {

        this.reference = reference;
        this.price = price;
        this.quantity = quantity;

    }

    public void setId(Integer id) { this.id = id; }
    public void setReference(String reference) { this.reference = reference; }
    public void setPrice(Float price) { this.price = price; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setProduct(Product product) { this.product = product; }
    public void setOrder(Order order) { this.order = order; }

    public Integer getId() { return id; }
    public String getReference() { return reference; }
    public Float getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public Product getProduct() { return product; }
    public Order getOrder() { return order; }

}
