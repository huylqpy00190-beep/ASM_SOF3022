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
    private Boolean activated;
    private Boolean admin;

    @OneToMany(mappedBy = "account")
    private List<Order> orders;
}

