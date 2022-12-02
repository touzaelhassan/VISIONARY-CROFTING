package com.application.services.classes;

import com.application.entities.Order;
import com.application.repositories.OrderRepository;
import com.application.services.interfaces.OrderServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceClass implements OrderServiceInterface {

    OrderRepository orderRepository;

    public OrderServiceClass(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    @Override
    public Order addOrder(Order order) { return orderRepository.save(order); }

    @Override
    public Order getOrderById(Integer orderId) { return orderRepository.findById(orderId).orElse(null); }

    @Override
    public List<Order> getOrders() { return orderRepository.findAll(); }

}
