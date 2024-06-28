package org.example.codingtestassignment.Controller;

import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/total-amount-by-date")
    public ResponseEntity<BigDecimal> getTotalSaleAmountByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        BigDecimal totalAmount = saleService.getTotalSaleAmountByDate(date);
        return ResponseEntity.ok(totalAmount);
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<LocalDate> getMaxSaleDayInRange(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                          @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        LocalDate maxSaleDay = saleService.getMaxSaleDayInRange(startDate, endDate);
        return ResponseEntity.ok(maxSaleDay);
    }

    @GetMapping("/top-5-selling-all-time")
    public ResponseEntity<List<Sale>> getTop5SellingItemsOfAllTime() {
        List<Sale> top5Sales = saleService.getTop5SellingItemsOfAllTime();
        return ResponseEntity.ok(top5Sales);
    }

    @GetMapping("/top-5-selling-last-month")
    public ResponseEntity<List<Sale>> getTop5SellingItemsOfLastMonth() {
        List<Sale> top5Sales = saleService.getTop5SellingItemsOfLastMonth();
        return ResponseEntity.ok(top5Sales);
    }
}
