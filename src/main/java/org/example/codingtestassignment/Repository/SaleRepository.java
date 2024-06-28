package org.example.codingtestassignment.Repository;

import org.example.codingtestassignment.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT COALESCE(SUM(s.amount), 0) FROM Sale s WHERE s.saleDate = :date")
    BigDecimal getTotalSaleAmountByDate(LocalDate date);

    @Query(value = "SELECT s.saleDate FROM Sale s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.saleDate ORDER BY SUM(s.amount) DESC LIMIT 1", nativeQuery = true)
    LocalDate getMaxSaleDayInRange(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT s.* FROM Sale s GROUP BY s.item_id ORDER BY SUM(s.amount) DESC LIMIT 5", nativeQuery = true)
    List<Sale> getTop5SellingItemsOfAllTime();

    @Query(value = "SELECT s.* FROM Sale s WHERE MONTH(s.sale_date) = MONTH(CURRENT_DATE) AND YEAR(s.sale_date) = YEAR(CURRENT_DATE) GROUP BY s.item_id ORDER BY COUNT(s.id) DESC LIMIT 5", nativeQuery = true)
    List<Sale> getTop5SellingItemsOfLastMonth();

    List<Sale> findTop5ByOrderByAmountDesc();
}
