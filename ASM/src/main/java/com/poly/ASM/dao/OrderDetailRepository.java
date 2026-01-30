package com.poly.ASM.dao;

import com.poly.ASM.entity.OrderDetail;
import com.poly.ASM.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository
        extends JpaRepository<OrderDetail, Long> {

    // Chi tiết 1 đơn hàng
    List<OrderDetail> findByOrderId(Long orderId);

    // Các sản phẩm đã mua
    @Query("""
        SELECT DISTINCT od.product
        FROM OrderDetail od
        WHERE od.order.account.username = ?1
    """)
    List<Product> findProductsByUsername(String username);
}


