package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testItemConstructorAndGettersSetters() {
        // Given
        String name = "Test Item";
        double price = 10.0;

        // When
        Item item = new Item(name, price);

        // Then
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
    }
}
