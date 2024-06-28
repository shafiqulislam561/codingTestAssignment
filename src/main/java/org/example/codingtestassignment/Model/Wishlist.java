package org.example.codingtestassignment.Model;

import jakarta.persistence.*;
import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Model.Item;

@Entity
@Table(name = "wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // Constructors, getters, and setters

    public Wishlist() {
    }

    public Wishlist(Customer customer, Item item) {
        this.customer = customer;
        this.item = item;
    }

    public Wishlist(long l, String s, long l1) {
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
