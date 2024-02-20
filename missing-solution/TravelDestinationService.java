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
       //Complete the Code
    }

    public List<TravelDestination> getStateList()
    {
        //Complete the Code
    }
    public List<TravelDestination> getByStateList(String stateName)
    {
       //Complete the Code
    }
    
}
