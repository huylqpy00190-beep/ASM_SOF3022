package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.ReportService;
import com.poly.ASM.dao.ReportRepository;
import com.poly.ASM.dto.RevenueReport;
import com.poly.ASM.dto.VipCustomerReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repo;

    @Override
    public List<RevenueReport> revenueByCategory() {
        return repo.getRevenueByCategory();
    }

    @Override
    public List<VipCustomerReport> top10VipCustomers() {
        return repo.getTop10VipCustomers();
    }
}


