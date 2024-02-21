package com.wecp.logisticsmanagementandtrackingsystem.service;

import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.entity.Driver;
import com.wecp.logisticsmanagementandtrackingsystem.repository.CargoRepository;
import com.wecp.logisticsmanagementandtrackingsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class DriverService {


    public Driver createDriver(Driver driver) {
        // add driver to database
    }

    public List<Driver> getAllDrivers() {
      // return list of drivers from database
    }

    public List<Cargo> viewDriverCargos(Long driverId) {
        // get assigned cargos of driver from database
    }

    public boolean updateCargoStatus(Long cargoId, String newStatus) {
        // update cargo status in database
    }



}
