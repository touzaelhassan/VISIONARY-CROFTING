package com.application.entities;

import com.application.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    private Date date;
    private Float totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer ;

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>();

    public Order() { }

    public Order(String reference, Date date, Float totalPrice, OrderStatus orderStatus) {

        this.reference = reference;
        this.date = date;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;

    }

    public void setId(Integer id) { this.id = id; }
    public void setReference(String reference) { this.reference = reference; }
    public void setDate(Date date) { this.date = date; }
    public void setTotalPrice(Float totalPrice) { this.totalPrice = totalPrice; }
    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public Integer getId() { return id; }
    public String getReference() { return reference; }
    public Date getDate() { return date; }
    public Float getTotalPrice() { return totalPrice; }
    public OrderStatus getOrderStatus() { return orderStatus; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getOrderItems() { return orderItems; }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
