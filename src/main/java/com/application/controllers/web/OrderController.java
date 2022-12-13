package com.application.controllers.web;


import com.application.entities.Order;
import com.application.services.classes.OrderServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    OrderServiceClass orderServiceClass;

    public OrderController(OrderServiceClass orderServiceClass) { this.orderServiceClass = orderServiceClass; }

    @GetMapping("")
    public List<Order> getOrders(){ return orderServiceClass.getOrders(); }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable Integer orderId){ return orderServiceClass.getOrderById(orderId); }

    @PostMapping("/create")
    public Order addOrder(@RequestBody Order order){ return orderServiceClass.addOrder(order); }

}
