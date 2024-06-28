package org.example.codingtestassignment.Controller;

import org.example.codingtestassignment.Model.Wishlist;
import org.example.codingtestassignment.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Wishlist>> getWishlistByCustomerId(@PathVariable("customerId") Long customerId) {
        List<Wishlist> wishlists = wishlistService.getWishlistByCustomerId(customerId);
        return ResponseEntity.ok(wishlists);
    }
}
