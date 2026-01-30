package com.poly.ASM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevenueReport {
    private String category;
    private Double totalRevenue;
    private Long totalQuantity;
    private Double maxPrice;
    private Double minPrice;
    private Double avgPrice;
}

