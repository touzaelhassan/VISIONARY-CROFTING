package com.application.controllers.web;


import com.application.entities.Order;
import com.application.services.classes.OrderServiceClass;
import com.application.services.interfaces.OrderServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderServiceInterface orderServiceBean;

    public OrderController(OrderServiceInterface orderServiceBean) { this.orderServiceBean = orderServiceBean; }

    @GetMapping("")
    public List<Order> getOrders(){ return orderServiceBean.getOrders(); }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable Integer orderId){ return orderServiceBean.getOrderById(orderId); }

    @PostMapping("/create")
    public Order addOrder(@RequestBody Order order){ return orderServiceBean.addOrder(order); }

}
