package com.wecp.travelmanagementsystem.repository;

import com.wecp.travelmanagementsystem.entity.TravelDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelDestinationRepository  extends JpaRepository<TravelDestination, Long>{
    List<TravelDestination> findByState(String statename);

}
