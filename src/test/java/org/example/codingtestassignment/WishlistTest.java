package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Wishlist;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WishlistTest {

    @Test
    public void testWishlistConstructorAndGettersSetters() {
        // Given
        Customer customer = new Customer("Test Customer");
        Item item = new Item("Test Item", 10.0);

        // When
        Wishlist wishlist = new Wishlist(customer, item);

        // Then
        assertEquals(customer, wishlist.getCustomer());
        assertEquals(item, wishlist.getItem());
    }
}
