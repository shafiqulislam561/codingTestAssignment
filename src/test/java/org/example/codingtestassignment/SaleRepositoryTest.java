package org.example.codingtestassignment;

import jakarta.transaction.Transactional;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Sale;
import org.example.codingtestassignment.Repository.CustomerRepository;
import org.example.codingtestassignment.Repository.ItemRepository;
import org.example.codingtestassignment.Repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SaleRepositoryTest {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        saleRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testSaveSale() {
        Item item = new Item("Test Item", 10.0);
        itemRepository.save(item);

        Customer customer = new Customer("Test Customer");
        customerRepository.save(customer);

        LocalDate saleDate = LocalDate.now();
        BigDecimal amount = BigDecimal.valueOf(100.0);
        Sale sale = new Sale(item, customer, saleDate, amount);

        Sale savedSale = saleRepository.save(sale);

        assertEquals(1, saleRepository.count());
        assertEquals(sale.getItem().getName(), savedSale.getItem().getName());
        assertEquals(sale.getCustomer().getName(), savedSale.getCustomer().getName());
        assertEquals(sale.getSaleDate(), savedSale.getSaleDate());
        assertEquals(sale.getAmount(), savedSale.getAmount());
    }

    @Test
    public void testFindTop5ByOrderByAmountDesc() {
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 15.0);

        itemRepository.saveAll(List.of(item1, item2));
        Customer customer = new Customer("Test Customer");
        customerRepository.save(customer);
        LocalDate saleDate = LocalDate.now();

        Sale sale1 = new Sale(item1, customer, saleDate, BigDecimal.valueOf(100.0));
        Sale sale2 = new Sale(item2, customer, saleDate, BigDecimal.valueOf(150.0));
        saleRepository.saveAll(List.of(sale1, sale2));

        List<Sale> topSales = saleRepository.findTop5ByOrderByAmountDesc();

        assertEquals(2, saleRepository.count());
        assertEquals(2, topSales.size());
        assertEquals(item2.getName(), topSales.get(0).getItem().getName());
        assertEquals(item1.getName(), topSales.get(1).getItem().getName());
    }

}
