package com.wecp.travelmanagementsystem.Controller;


import com.wecp.travelmanagementsystem.entity.TravelDestination;
import com.wecp.travelmanagementsystem.service.TravelDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/api")
@EnableWebMvc
public class TravelDestinationController {

    @Autowired
    TravelDestinationService travelDestinationService;

    @PostMapping("/Adddestination")
    public ResponseEntity<TravelDestination> addCargo(@RequestBody TravelDestination travelDestinationBody) {
        TravelDestination travelDestination = travelDestinationService.addDestination(travelDestinationBody);
        return new ResponseEntity<>(travelDestination, HttpStatus.OK);
    }
    @GetMapping("/state")
    public ResponseEntity<List<TravelDestination>> getAllState() {
        List<TravelDestination> allStattes = travelDestinationService.getStateList();
        return ResponseEntity.ok(allStattes);
    }
    @PostMapping("/state")
    public ResponseEntity<List<TravelDestination>> getAllState(@RequestParam String name) {
        List<TravelDestination> Stattes = travelDestinationService.getByStateList(name);
        return ResponseEntity.ok(Stattes);
    }


}
