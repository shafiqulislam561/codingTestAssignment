package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("Test Customer");
        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(1, customerRepository.count());
        assertEquals(customer.getName(), savedCustomer.getName());
    }

    @Test
    public void testFindById() {
        Customer customer = new Customer("Test Customer");
        Customer savedCustomer = customerRepository.save(customer);
        Optional<Customer> retrievedCustomer = customerRepository.findById(savedCustomer.getId());
        assertTrue(retrievedCustomer.isPresent());
        assertEquals(savedCustomer.getName(), retrievedCustomer.get().getName());
    }

    @Test
    public void testFindAll() {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        customerRepository.saveAll(List.of(customer1, customer2));
        List<Customer> customers = customerRepository.findAll();
        assertEquals(2, customers.size());
    }
}
