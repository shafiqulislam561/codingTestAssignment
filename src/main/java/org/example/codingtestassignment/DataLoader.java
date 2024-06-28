package org.example.codingtestassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;
import org.example.codingtestassignment.Model.Item;
import org.example.codingtestassignment.Model.Customer;
import org.example.codingtestassignment.Repository.CustomerRepository;
import org.example.codingtestassignment.Repository.ItemRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Generate items
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setName(faker.commerce().productName());
            item.setPrice(faker.number().randomDouble(2, 10, 100));
            itemRepository.save(item);
        }

        // Generate customers
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customerRepository.save(customer);
        }
    }
}
