package com.poly.ASM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;

    // Gán giá trị mặc định để tránh null khi lấy từ DB hoặc tạo mới
    private Boolean activated = false;
    private Boolean admin = false;

    @OneToMany(mappedBy = "account")
    private List<Order> orders;
}

