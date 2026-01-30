package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.OrderDetailService;
import com.poly.ASM.dao.OrderDetailRepository;
import com.poly.ASM.entity.OrderDetail;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepo;

    @Override
    public OrderDetail create(OrderDetail detail) {
        return orderDetailRepo.save(detail);
    }

    @Override
    public List<OrderDetail> findByOrderId(Long orderId) {
        return orderDetailRepo.findByOrderId(orderId);
    }

    @Override
    public List<Product> findProductsByUsername(String username) {
        return orderDetailRepo.findProductsByUsername(username);
    }
}
