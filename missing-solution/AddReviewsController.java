package com.wecp.travelmanagementsystem.Controller;

import com.wecp.travelmanagementsystem.entity.Review;
import com.wecp.travelmanagementsystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api")
public class AddReviewsController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review rev)
    {
       //Complete Code

    }

    @PutMapping("/updateReview")
    public ResponseEntity<String> editReview(@RequestParam Long reviewId, @RequestParam String reviewDetails) {
         //Complete Code
    }
    @GetMapping("/review")
    public ResponseEntity<List<Review>> getAllReview() {
         //Complete Code
    }
    @PostMapping ("/reviewByid")
    public ResponseEntity<Optional<Review>> getReviewById(@RequestParam long id)
    {
          //Complete Code
    }



}
