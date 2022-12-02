package com.application.services.interfaces;

import com.application.entities.Order;

import java.util.List;

public interface OrderServiceInterface {

    Order addOrder(Order order);
    Order getOrderById(Integer orderId);
    List<Order> getOrders();

}
