package com.wecp.travelmanagementsystem.service;



import com.wecp.travelmanagementsystem.entity.Customer;
import com.wecp.travelmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        //Complete the Code
    }


}
