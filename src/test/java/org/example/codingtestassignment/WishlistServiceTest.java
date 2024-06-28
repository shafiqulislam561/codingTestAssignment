package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Wishlist;
import org.example.codingtestassignment.Repository.WishlistRepository;
import org.example.codingtestassignment.Service.WishlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWishlistByCustomerId() {
        // Given
        Long customerId = 1L;
        Wishlist wishlist1 = new Wishlist(new Customer("Test Customer"), new Item("Test Item 1", 10.0));
        Wishlist wishlist2 = new Wishlist(new Customer("Test Customer"), new Item("Test Item 2", 15.0));
        List<Wishlist> wishlists = Arrays.asList(wishlist1, wishlist2);
        when(wishlistRepository.findByCustomerId(customerId)).thenReturn(wishlists);

        // When
        List<Wishlist> result = wishlistService.getWishlistByCustomerId(customerId);

        // Then
        assertEquals(wishlists.size(), result.size());
    }
}
