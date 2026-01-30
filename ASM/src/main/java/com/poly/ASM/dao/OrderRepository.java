package com.poly.ASM.dao;

import com.poly.ASM.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    // Đơn hàng của 1 user
    List<Order> findByAccountUsername(String username);

    // Đơn hàng theo khoảng ngày
    @Query("""
        SELECT o FROM Order o
        WHERE o.createDate BETWEEN ?1 AND ?2
    """)
    List<Order> findByDateRange(Date from, Date to);
}

