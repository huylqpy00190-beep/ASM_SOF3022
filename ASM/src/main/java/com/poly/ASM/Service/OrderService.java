package com.poly.ASM.Service;

import com.poly.ASM.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order create(Order order);
    List<Order> findByUsername(String username);
    Order findById(Long id);
}


