package com.wecp.travelmanagementsystem.entity;

import javax.persistence.*;
@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewDetails;
	//Complete Mapping code
    private Customer customer;

    //Complete Mapping code
    private TravelDestination travelDestination;

    public Review() {
    }

    public Review(Long id, String reviewDetails, Customer customer, TravelDestination travelDestination) {
        this.id = id;
        this.reviewDetails = reviewDetails;
        this.customer = customer;
        this.travelDestination = travelDestination;
    }

    public Review(String reviewDetails, Customer customer, TravelDestination travelDestination) {
        this.reviewDetails = reviewDetails;
        this.customer = customer;
        this.travelDestination = travelDestination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewDetails() {
        return reviewDetails;
    }

    public void setReviewDetails(String reviewDetails) {
        this.reviewDetails = reviewDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TravelDestination getTravelDestination() {
        return travelDestination;
    }

    public void setTravelDestination(TravelDestination travelDestination) {
        this.travelDestination = travelDestination;
    }
}
