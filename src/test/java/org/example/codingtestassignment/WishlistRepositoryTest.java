package org.example.codingtestassignment;

import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Wishlist;
import org.example.codingtestassignment.Repository.CustomerRepository;
import org.example.codingtestassignment.Repository.ItemRepository;
import org.example.codingtestassignment.Repository.WishlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class WishlistRepositoryTest {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        // Clear any existing data before each test
        wishlistRepository.deleteAll();
        customerRepository.deleteAll();
        itemRepository.deleteAll();
    }

    @Test
    public void testSaveWishlist() {
        // Given
        Customer customer = new Customer("Test Customer");
        customerRepository.save(customer);

        Item item = new Item("Test Item", 10.0);
        itemRepository.save(item);

        Wishlist wishlist = new Wishlist(customer, item);

        // When
        Wishlist savedWishlist = wishlistRepository.save(wishlist);

        // Then
        assertEquals(1, wishlistRepository.count());
        assertEquals(wishlist.getCustomer(), savedWishlist.getCustomer());
        assertEquals(wishlist.getItem(), savedWishlist.getItem());
    }

    @Test
    public void testFindByCustomerId() {
        // Given
        Customer customer = new Customer("Test Customer");
        customerRepository.save(customer);

        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 15.0);
        itemRepository.saveAll(List.of(item1, item2));

        Wishlist wishlist1 = new Wishlist(customer, item1);
        Wishlist wishlist2 = new Wishlist(customer, item2);

        wishlistRepository.saveAll(List.of(wishlist1, wishlist2));

        // When
        List<Wishlist> wishlists = wishlistRepository.findByCustomerId(customer.getId());

        // Then
        assertEquals(2, wishlists.size());
        assertEquals(customer.getId(), wishlists.get(0).getCustomer().getId());
    }
}
