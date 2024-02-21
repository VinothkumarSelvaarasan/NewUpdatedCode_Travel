package com.wecp.logisticsmanagementandtrackingsystem.Controller;


import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.entity.Driver;
import com.wecp.logisticsmanagementandtrackingsystem.service.CargoService;
import com.wecp.logisticsmanagementandtrackingsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

public class BusinessController {


    private CargoService cargoService;

    private DriverService driverService;


    @PostMapping("/api/business/cargo")
    public ResponseEntity<Cargo> addCargo(@RequestBody Cargo cargo) {
        // add cargo  and return the added cargo with status code 200
    }

    @GetMapping("/api/business/drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {{
        // return list of drivers
    }

    @GetMapping("/api/business/cargo")
    public ResponseEntity<List<Cargo>> viewAllCargos() {
        // return all cargos with status code 200
    }

    @@PostMapping("/api/business/assign-cargo")
    public ResponseEntity<String> assignCargoToDriver(@RequestParam Long cargoId, @RequestParam Long driverId) {
        // assign cargo to a driver

        if (assignmentSuccess) {
            // if assignment is sucess return with this message
            return ResponseEntity.ok().body("{\"message\": \"Cargo assigned successfully.\"}");
        } else {
            // if assignemnt failed return with this message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign cargo.");
        }
    }
}
