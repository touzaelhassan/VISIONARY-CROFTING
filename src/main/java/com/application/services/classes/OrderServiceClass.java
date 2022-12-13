package com.application.services.classes;

import com.application.entities.Order;
import com.application.repositories.OrderRepository;
import com.application.services.interfaces.OrderServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderServiceBean")
public class OrderServiceClass implements OrderServiceInterface {

    private OrderRepository orderRepositoryBean;

    public OrderServiceClass(OrderRepository orderRepository) { this.orderRepositoryBean = orderRepository; }

    @Override
    public Order addOrder(Order order) { return orderRepositoryBean.save(order); }

    @Override
    public Order getOrderById(Integer orderId) { return orderRepositoryBean.findById(orderId).orElse(null); }

    @Override
    public List<Order> getOrders() { return orderRepositoryBean.findAll(); }

}
