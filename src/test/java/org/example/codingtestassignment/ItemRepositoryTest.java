package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Repository.ItemRepository;
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
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        // Clear any existing data before each test
        itemRepository.deleteAll();
    }

    @Test
    public void testSaveItem() {
        // Given
        Item item = new Item("Test Item", 10.0);

        // When
        Item savedItem = itemRepository.save(item);

        // Then
        assertEquals(1, itemRepository.count());
        assertEquals(item.getName(), savedItem.getName());
        assertEquals(item.getPrice(), savedItem.getPrice());
    }

    @Test
    public void testFindById() {
        // Given
        Item item = new Item("Test Item", 10.0);
        Item savedItem = itemRepository.save(item);

        // When
        Optional<Item> retrievedItem = itemRepository.findById(savedItem.getId());

        // Then
        assertTrue(retrievedItem.isPresent());
        assertEquals(savedItem.getName(), retrievedItem.get().getName());
    }

    @Test
    public void testFindAll() {
        // Given
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 15.0);

        itemRepository.saveAll(List.of(item1, item2));

        // When
        List<Item> items = itemRepository.findAll();

        // Then
        assertEquals(2, items.size());
    }
}
