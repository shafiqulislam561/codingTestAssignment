package org.example.codingtestassignment.Service;

import org.example.codingtestassignment.Model.Wishlist;
import org.example.codingtestassignment.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getWishlistByCustomerId(Long customerId) {
        return wishlistRepository.findByCustomerId(customerId);
    }


}
