package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Repository.CustomerRepository;
import org.example.codingtestassignment.Service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        // Given
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerRepository.findAll()).thenReturn(customers);

        // When
        ResponseEntity<List<Customer>> response = customerService.getAllCustomers();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers.size(), response.getBody().size());
    }

    @Test
    public void testGetCustomerById() {
        // Given
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);
        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(customerRepository.findById(customerId)).thenReturn(optionalCustomer);

        // When
        ResponseEntity<Customer> response = customerService.getCustomerById(customerId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer.getId(), response.getBody().getId());
    }
}
