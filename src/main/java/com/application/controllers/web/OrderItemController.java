package com.application.controllers.web;

import com.application.entities.OrderItem;
import com.application.services.classes.OrderItemServiceClass;
import com.application.services.interfaces.OrderItemServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    private OrderItemServiceInterface orderItemServiceBean;

    public OrderItemController(OrderItemServiceInterface orderItemServiceBean) { this.orderItemServiceBean = orderItemServiceBean; }

    @GetMapping("")
    public List<OrderItem> getOrderItems(){ return orderItemServiceBean.getOrderItems(); }

    @GetMapping("/order-item/{orderItemId}")
    public OrderItem getOrderItem(@PathVariable Integer orderItemId){ return orderItemServiceBean.getOrderItemById(orderItemId); }

    @PostMapping("/create")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem){ return orderItemServiceBean.addOrderItem(orderItem); }

}
