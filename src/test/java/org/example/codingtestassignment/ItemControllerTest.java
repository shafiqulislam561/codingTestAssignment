package org.example.codingtestassignment;

import org.example.codingtestassignment.Controller.ItemController;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

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
        when(itemService.getAllItems()).thenReturn(items);

        // When
        ResponseEntity<List<Item>> response = itemController.getAllItems();

        // Then
        assertEquals(items.size(), response.getBody().size());
    }

    @Test
    public void testGetItemById() {
        // Given
        Long itemId = 1L;
        Item item = new Item();
        item.setId(itemId);
        when(itemService.getItemById(itemId)).thenReturn(Optional.of(item));

        // When
        ResponseEntity<Item> response = itemController.getItemById(itemId);

        // Then
        assertEquals(item.getId(), response.getBody().getId());
    }
}
