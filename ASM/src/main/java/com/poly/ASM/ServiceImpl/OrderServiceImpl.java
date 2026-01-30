package com.poly.ASM.ServiceImpl;




import com.poly.ASM.Service.OrderService;
import com.poly.ASM.dao.OrderRepository;
import com.poly.ASM.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Override
    public Order create(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderRepo.findByAccountUsername(username);
    }

    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
}

