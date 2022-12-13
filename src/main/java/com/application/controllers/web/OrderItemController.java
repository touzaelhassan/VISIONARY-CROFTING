package com.application.controllers.web;

import com.application.entities.OrderItem;
import com.application.services.classes.OrderItemServiceClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    OrderItemServiceClass orderItemServiceClass;

    public OrderItemController(OrderItemServiceClass orderItemServiceClass) { this.orderItemServiceClass = orderItemServiceClass; }

    @GetMapping("")
    public List<OrderItem> getOrderItems(){ return orderItemServiceClass.getOrderItems(); }

    @GetMapping("/order-item/{orderItemId}")
    public OrderItem getOrderItem(@PathVariable Integer orderItemId){ return orderItemServiceClass.getOrderItemById(orderItemId); }

    @PostMapping("/create")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem){ return orderItemServiceClass.addOrderItem(orderItem); }

}
