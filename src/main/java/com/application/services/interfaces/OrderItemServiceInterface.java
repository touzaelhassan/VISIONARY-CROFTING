package com.application.services.interfaces;

import com.application.entities.OrderItem;

import java.util.List;

public interface OrderItemServiceInterface {

    OrderItem addOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Integer orderItemId);
    List<OrderItem> getOrderItems();

}
