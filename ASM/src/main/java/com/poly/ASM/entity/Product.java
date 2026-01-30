package com.poly.ASM.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String image;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();

    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}