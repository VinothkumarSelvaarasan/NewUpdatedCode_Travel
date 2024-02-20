package com.wecp.travelmanagementsystem.repository;


import com.wecp.travelmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional business-related query methods can be added here
}