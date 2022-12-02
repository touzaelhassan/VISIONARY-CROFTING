package com.application.services.classes;

import com.application.entities.OrderItem;
import com.application.repositories.OrderItemRepository;
import com.application.services.interfaces.OrderItemServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceClass implements OrderItemServiceInterface {

    OrderItemRepository orderItemRepository;

    public OrderItemServiceClass(OrderItemRepository orderItemRepository) { this.orderItemRepository = orderItemRepository; }

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) { return orderItemRepository.save(orderItem); }

    @Override
    public OrderItem getOrderItemById(Integer orderItemId) { return orderItemRepository.findById(orderItemId).orElse(null); }

    @Override
    public List<OrderItem> getOrderItems() { return orderItemRepository.findAll(); }

}
