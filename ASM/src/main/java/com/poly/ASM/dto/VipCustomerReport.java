package com.poly.ASM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class VipCustomerReport {
    private String fullname;
    private Double totalAmount;
    private Date firstOrderDate;
    private Date lastOrderDate;
}
