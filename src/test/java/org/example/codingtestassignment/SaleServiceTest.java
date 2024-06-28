package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Repository.SaleRepository;
import org.example.codingtestassignment.Service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleService saleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTotalSaleAmountByDate() {
        // Given
        LocalDate date = LocalDate.now();
        BigDecimal totalAmount = BigDecimal.valueOf(100.0);
        when(saleRepository.getTotalSaleAmountByDate(date)).thenReturn(totalAmount);

        // When
        BigDecimal result = saleService.getTotalSaleAmountByDate(date);

        // Then
        assertEquals(totalAmount, result);
    }

    @Test
    public void testGetMaxSaleDayInRange() {
        // Given
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        LocalDate maxSaleDay = LocalDate.now().minusDays(3);
        when(saleRepository.getMaxSaleDayInRange(startDate, endDate)).thenReturn(maxSaleDay);

        // When
        LocalDate result = saleService.getMaxSaleDayInRange(startDate, endDate);

        // Then
        assertEquals(maxSaleDay, result);
    }

    @Test
    public void testGetTop5SellingItemsOfAllTime() {
        // Given
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        Sale sale3 = new Sale();
        List<Sale> top5Sales = Arrays.asList(sale1, sale2, sale3);
        when(saleRepository.getTop5SellingItemsOfAllTime()).thenReturn(top5Sales);

        // When
        List<Sale> result = saleService.getTop5SellingItemsOfAllTime();

        // Then
        assertEquals(top5Sales.size(), result.size());
    }

    @Test
    public void testGetTop5SellingItemsOfLastMonth() {
        // Given
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        Sale sale3 = new Sale();
        List<Sale> top5Sales = Arrays.asList(sale1, sale2, sale3);
        when(saleRepository.getTop5SellingItemsOfLastMonth()).thenReturn(top5Sales);

        // When
        List<Sale> result = saleService.getTop5SellingItemsOfLastMonth();

        // Then
        assertEquals(top5Sales.size(), result.size());
    }
}
