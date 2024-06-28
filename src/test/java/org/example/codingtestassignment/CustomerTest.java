package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructorAndGettersSetters() {
        // Given
        String name = "Test Customer";

        // When
        Customer customer = new Customer(name);

        // Then
        assertEquals(name, customer.getName());
    }
}
