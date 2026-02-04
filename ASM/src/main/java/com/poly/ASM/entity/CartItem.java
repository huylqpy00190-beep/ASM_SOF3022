package com.poly.ASM.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Product product; // Đối tượng sản phẩm
    private Integer quantity;
}
