package com.wecp.travelmanagementsystem.service;

import com.wecp.travelmanagementsystem.entity.TravelDestination;
import com.wecp.travelmanagementsystem.repository.TravelDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelDestinationService {
    @Autowired
    TravelDestinationRepository travelDestinationRepository;

    public TravelDestination addDestination(TravelDestination travelDestination)
    {
        return travelDestinationRepository.save(travelDestination);
    }

    public List<TravelDestination> getStateList()
    {
        return travelDestinationRepository.findAll();
    }
    public List<TravelDestination> getByStateList(String stateName)
    {
        return travelDestinationRepository.findByState(stateName);
    }
    
}
