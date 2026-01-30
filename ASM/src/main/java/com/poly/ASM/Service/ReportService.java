package com.poly.ASM.Service;

import com.poly.ASM.dto.RevenueReport;
import com.poly.ASM.dto.VipCustomerReport;

import java.util.List;

public interface ReportService {

    List<RevenueReport> revenueByCategory();

    List<VipCustomerReport> top10VipCustomers();
}

