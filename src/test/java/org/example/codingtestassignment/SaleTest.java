package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Sale;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    @Test
    public void testSaleConstructorAndGettersSetters() {
        // Given
        Item item = new Item("Test Item", 10.0);
        Customer customer = new Customer("Test Customer");
        LocalDate saleDate = LocalDate.now();
        BigDecimal amount = BigDecimal.valueOf(100.0);

        // When
        Sale sale = new Sale(item, customer, saleDate, amount);

        // Then
        assertEquals(item, sale.getItem());
        assertEquals(customer, sale.getCustomer());
        assertEquals(saleDate, sale.getSaleDate());
        assertEquals(amount, sale.getAmount());
    }
}
