package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Repository.ItemRepository;
import org.example.codingtestassignment.Service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllItems() {
        // Given
        Item item1 = new Item();
        Item item2 = new Item();
        List<Item> items = Arrays.asList(item1, item2);
        when(itemRepository.findAll()).thenReturn(items);

        // When
        List<Item> result = itemService.getAllItems();

        // Then
        assertEquals(items.size(), result.size());
    }

    @Test
    public void testGetItemById() {
        // Given
        Long itemId = 1L;
        Item item = new Item();
        item.setId(itemId);
        when(itemRepository.findById(itemId)).thenReturn(Optional.of(item));

        // When
        Optional<Item> result = itemService.getItemById(itemId);

        // Then
        assertEquals(item.getId(), result.get().getId());
    }
}
