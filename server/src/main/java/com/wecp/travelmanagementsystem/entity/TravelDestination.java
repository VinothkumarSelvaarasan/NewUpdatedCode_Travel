package com.wecp.travelmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="travel_destination")
public class TravelDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String locationName;
    private String highLights;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    

    public String getHighLights() {
        return highLights;
    }

    public void setHighLights(String highLights) {
        this.highLights = highLights;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
