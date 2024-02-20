package com.wecp.travelmanagementsystem.service;

import com.wecp.travelmanagementsystem.entity.Business;
import com.wecp.travelmanagementsystem.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {


    @Autowired
    private BusinessRepository businessRepository;

    public Business registerBusiness(Business business) {
        return businessRepository.save(business);
    }
}
