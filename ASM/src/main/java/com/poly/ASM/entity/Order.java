package com.poly.ASM.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class    Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Createdate")
    private Date createDate = new Date();

    private String address;

    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
    @PrePersist
    public void prePersist() {
        this.createDate = new Date(); // Luôn lấy giờ hệ thống khi tạo đơn hàng mới
    }
}