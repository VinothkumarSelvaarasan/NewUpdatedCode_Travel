package com.wecp.logisticsmanagementandtrackingsystem.service;

import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.entity.Driver;
import com.wecp.logisticsmanagementandtrackingsystem.repository.CargoRepository;
import com.wecp.logisticsmanagementandtrackingsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class CargoService {



    public Cargo addCargo(Cargo cargo) {
        // add cargo to database
    }

    public List<Cargo> viewAllCargos() {
       // get all cargos from database
    }

    public boolean assignCargoToDriver(Long cargoId, Long driverId) {
        // assign cargo to driver
    }
}
