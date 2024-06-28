package org.example.codingtestassignment;

import org.example.codingtestassignment.Controller.SaleController;
import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SaleControllerTest {

    @Mock
    private SaleService saleService;

    @InjectMocks
    private SaleController saleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTotalSaleAmountByDate() {
        // Given
        LocalDate date = LocalDate.now();
        BigDecimal totalAmount = BigDecimal.valueOf(100.0);
        when(saleService.getTotalSaleAmountByDate(date)).thenReturn(totalAmount);

        // When
        ResponseEntity<BigDecimal> response = saleController.getTotalSaleAmountByDate(date);

        // Then
        assertEquals(totalAmount, response.getBody());
    }

    @Test
    public void testGetMaxSaleDayInRange() {
        // Given
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        LocalDate maxSaleDay = LocalDate.now().minusDays(3);
        when(saleService.getMaxSaleDayInRange(startDate, endDate)).thenReturn(maxSaleDay);

        // When
        ResponseEntity<LocalDate> response = saleController.getMaxSaleDayInRange(startDate, endDate);

        // Then
        assertEquals(maxSaleDay, response.getBody());
    }

    @Test
    public void testGetTop5SellingItemsOfAllTime() {
        // Given
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        Sale sale3 = new Sale();
        List<Sale> top5Sales = Arrays.asList(sale1, sale2, sale3);
        when(saleService.getTop5SellingItemsOfAllTime()).thenReturn(top5Sales);

        // When
        ResponseEntity<List<Sale>> response = saleController.getTop5SellingItemsOfAllTime();

        // Then
        assertEquals(top5Sales.size(), response.getBody().size());
    }

    @Test
    public void testGetTop5SellingItemsOfLastMonth() {
        // Given
        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        Sale sale3 = new Sale();
        List<Sale> top5Sales = Arrays.asList(sale1, sale2, sale3);
        when(saleService.getTop5SellingItemsOfLastMonth()).thenReturn(top5Sales);

        // When
        ResponseEntity<List<Sale>> response = saleController.getTop5SellingItemsOfLastMonth();

        // Then
        assertEquals(top5Sales.size(), response.getBody().size());
    }
}
