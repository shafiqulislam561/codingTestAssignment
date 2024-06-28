package org.example.codingtestassignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.codingtestassignment.Model.Wishlist;
import org.example.codingtestassignment.Service.WishlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WishlistControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishlistService wishlistService;

    @BeforeEach
    void setUp() {
        Wishlist wishlist1 = new Wishlist(1L, "Wishlist Item 1", 1L);
        Wishlist wishlist2 = new Wishlist(2L, "Wishlist Item 2", 1L);
        List<Wishlist> wishlist = Arrays.asList(wishlist1, wishlist2);

        Mockito.when(wishlistService.getWishlistByCustomerId(anyLong())).thenReturn(wishlist);
    }

    @Test
    public void testGetWishlistByCustomerId() throws Exception {
        mockMvc.perform(get("/api/wishlists/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].itemName").value("Wishlist Item 1"))
                .andExpect(jsonPath("$[0].customerId").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].itemName").value("Wishlist Item 2"))
                .andExpect(jsonPath("$[1].customerId").value(1));
    }

    @Configuration
    static class TestConfig {
        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }
}

