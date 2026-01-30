package com.poly.ASM.dao;

import com.poly.ASM.dto.RevenueReport;
import com.poly.ASM.dto.VipCustomerReport;
import com.poly.ASM.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<OrderDetail, Long> {

    // ======================
    // DOANH THU THEO LOẠI
    // ======================
    @Query("""
        SELECT new com.poly.ASM.dto.RevenueReport(
            c.name,
            SUM(d.price * d.quantity),
            SUM(d.quantity),
            MAX(d.price),
            MIN(d.price),
            AVG(d.price)
        )
        FROM OrderDetail d
        JOIN d.product p
        JOIN p.category c
        GROUP BY c.name
    """)
    List<RevenueReport> getRevenueByCategory();

    // ======================
    // TOP 10 KHÁCH VIP
    // ======================
    @Query("""
        SELECT new com.poly.ASM.dto.VipCustomerReport(
            a.fullname,
            SUM(d.price * d.quantity),
            MIN(o.createDate),
            MAX(o.createDate)
        )
        FROM OrderDetail d
        JOIN d.order o
        JOIN o.account a
        GROUP BY a.fullname
        ORDER BY SUM(d.price * d.quantity) DESC
    """)
    List<VipCustomerReport> getTop10VipCustomers();
}


