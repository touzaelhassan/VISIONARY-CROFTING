package com.application.controllers.api;


import com.application.entities.Order;
import com.application.services.interfaces.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private OrderServiceInterface orderServiceBean;

    @Autowired
    public OrderRestController(OrderServiceInterface orderServiceBean) { this.orderServiceBean = orderServiceBean; }

    @GetMapping("/")
    public List<Order> getOrders(){ return orderServiceBean.getOrders();}

    @PostMapping("/order/add")
    public Order saveOrder(@RequestBody Order order){ return orderServiceBean.addOrder(order); }

}
