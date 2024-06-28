package org.example.codingtestassignment.Repository;

import org.example.codingtestassignment.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
