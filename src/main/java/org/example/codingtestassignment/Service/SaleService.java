package org.example.codingtestassignment.Service;

import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public BigDecimal getTotalSaleAmountByDate(LocalDate date) {
        return saleRepository.getTotalSaleAmountByDate(date);
    }

    public LocalDate getMaxSaleDayInRange(LocalDate startDate, LocalDate endDate) {
        return saleRepository.getMaxSaleDayInRange(startDate, endDate);
    }

    public List<Sale> getTop5SellingItemsOfAllTime() {
        return saleRepository.getTop5SellingItemsOfAllTime();
    }

    public List<Sale> getTop5SellingItemsOfLastMonth() {
        return saleRepository.getTop5SellingItemsOfLastMonth();
    }
}
