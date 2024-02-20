package com.wecp.travelmanagementsystem.repository;


import com.wecp.travelmanagementsystem.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    // Additional business-related query methods can be added here
}
