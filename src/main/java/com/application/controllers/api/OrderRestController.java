package com.application.controllers.api;

import com.application.entities.Order;
import com.application.entities.OrderItem;
import com.application.services.interfaces.OrderItemServiceInterface;
import com.application.services.interfaces.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private OrderServiceInterface orderServiceBean;
    private OrderItemServiceInterface orderItemServiceBean;

    @Autowired
    public OrderRestController(OrderServiceInterface orderServiceBean) { this.orderServiceBean = orderServiceBean; }

    @GetMapping
    public List<Order> getOrders(){ return orderServiceBean.getOrders();}

    @PostMapping("/order/add")
    public Order saveOrder(@RequestBody Order order){
        Order savedOrder = orderServiceBean.addOrder(order);
        List<OrderItem> orderItems = savedOrder.getOrderItems();
        orderItems.forEach(orderItem -> { orderItemServiceBean.addOrderItem(orderItem); });
        return savedOrder;
    }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable Integer orderId){ return  orderServiceBean.getOrderById(orderId); }

}
