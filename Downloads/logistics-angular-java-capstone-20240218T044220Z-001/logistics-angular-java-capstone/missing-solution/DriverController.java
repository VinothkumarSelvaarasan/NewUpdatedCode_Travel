package com.wecp.logisticsmanagementandtrackingsystem.Controller;


import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class DriverController {

    private DriverService driverService;

    @GetMapping("/api/driver/cargo")
    public ResponseEntity<List<Cargo>> viewAssignedCargos(@RequestParam Long driverId) {
        // get assigned cargos for the driver and return with 200 OK
    }

    @PutMapping("/update-cargo-status")
    public ResponseEntity<String> updateCargoStatus(@RequestParam Long cargoId, @RequestParam String newStatus) {
        // update the cargo status

        if (updateSuccess) {
            // id cargo update sucessfully return this
            return ResponseEntity.ok().body("{\"message\": \"Cargo status updated successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update cargo status.");
        }
    }


}
