package com.poly.ASM.Service;

import com.poly.ASM.entity.OrderDetail;
import com.poly.ASM.entity.Product;

import java.util.List;

public interface OrderDetailService {
    OrderDetail create(OrderDetail detail);
    List<OrderDetail> findByOrderId(Long orderId);
    List<Product> findProductsByUsername(String username);
}
