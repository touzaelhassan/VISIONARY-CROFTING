package com.application.services.classes;

import com.application.entities.OrderItem;
import com.application.repositories.OrderItemRepository;
import com.application.services.interfaces.OrderItemServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderItemServiceBean")
public class OrderItemServiceClass implements OrderItemServiceInterface {

    private OrderItemRepository orderItemRepositoryBean;

    public OrderItemServiceClass(OrderItemRepository orderItemRepository) { this.orderItemRepositoryBean = orderItemRepository; }

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) { return orderItemRepositoryBean.save(orderItem); }

    @Override
    public OrderItem getOrderItemById(Integer orderItemId) { return orderItemRepositoryBean.findById(orderItemId).orElse(null); }

    @Override
    public List<OrderItem> getOrderItems() { return orderItemRepositoryBean.findAll(); }

}
