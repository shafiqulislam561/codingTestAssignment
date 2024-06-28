package org.example.codingtestassignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.codingtestassignment.Controller.SaleController;
import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SaleController.class)
@AutoConfigureMockMvc
public class SaleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaleService saleService;

    @BeforeEach
    void setUp() {
        when(saleService.getTotalSaleAmountByDate(any(LocalDate.class))).thenReturn(BigDecimal.valueOf(1000.0));
        when(saleService.getMaxSaleDayInRange(any(LocalDate.class), any(LocalDate.class))).thenReturn(LocalDate.of(2024, 6, 15));

        Sale sale1 = new Sale("Item1", BigDecimal.valueOf(500.0));
        Sale sale2 = new Sale("Item2", BigDecimal.valueOf(400.0));
        Sale sale3 = new Sale("Item3", BigDecimal.valueOf(300.0));
        Sale sale4 = new Sale("Item4", BigDecimal.valueOf(200.0));
        Sale sale5 = new Sale("Item5", BigDecimal.valueOf(100.0));
        List<Sale> top5SalesAllTime = Arrays.asList(sale1, sale2, sale3, sale4, sale5);
        when(saleService.getTop5SellingItemsOfAllTime()).thenReturn(top5SalesAllTime);

        List<Sale> top5SalesLastMonth = Arrays.asList(sale1, sale2, sale3, sale4, sale5);
        when(saleService.getTop5SellingItemsOfLastMonth()).thenReturn(top5SalesLastMonth);
    }

    @Test
    public void testGetTotalSaleAmountByDate() throws Exception {
        mockMvc.perform(get("/api/sales/total-amount-by-date")
                        .param("date", "2024-06-01")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(1000.0));
    }

    @Test
    public void testGetMaxSaleDayInRange() throws Exception {
        mockMvc.perform(get("/api/sales/max-sale-day")
                        .param("startDate", "2024-06-01")
                        .param("endDate", "2024-06-30")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value("2024-06-15"));
    }

    @Test
    public void testGetTop5SellingItemsOfAllTime() throws Exception {
        mockMvc.perform(get("/api/sales/top-5-selling-all-time")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[0].itemName").value("Item1"))
                .andExpect(jsonPath("$[1].itemName").value("Item2"))
                .andExpect(jsonPath("$[2].itemName").value("Item3"))
                .andExpect(jsonPath("$[3].itemName").value("Item4"))
                .andExpect(jsonPath("$[4].itemName").value("Item5"));
    }

    @Test
    public void testGetTop5SellingItemsOfLastMonth() throws Exception {
        mockMvc.perform(get("/api/sales/top-5-selling-last-month")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[0].itemName").value("Item1"))
                .andExpect(jsonPath("$[1].itemName").value("Item2"))
                .andExpect(jsonPath("$[2].itemName").value("Item3"))
                .andExpect(jsonPath("$[3].itemName").value("Item4"))
                .andExpect(jsonPath("$[4].itemName").value("Item5"));
    }

    @Configuration
    static class TestConfig {
        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }
}
