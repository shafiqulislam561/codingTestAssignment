package org.example.codingtestassignment;

import org.example.codingtestassignment.Controller.CustomerController;
import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

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
        ResponseEntity<List<Customer>> expectedResponse = ResponseEntity.ok(customers);
        when(customerService.getAllCustomers()).thenReturn(expectedResponse);
        // When
        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();
        // Then
        assertEquals(customers.size(), response.getBody().size());
    }

    @Test
    public void testGetCustomerById() {
        // Given
        Long customerId = 1L;
        Customer customer = new Customer();
        ResponseEntity<Customer> expectedResponse = ResponseEntity.ok(customer);
        when(customerService.getCustomerById(customerId)).thenReturn(expectedResponse);
        // When
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);
        // Then
        assertEquals(customer.getId(), Objects.requireNonNull(response.getBody()).getId());
    }
}
