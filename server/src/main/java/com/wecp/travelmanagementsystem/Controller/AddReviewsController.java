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
        Review review = reviewService.addReview(rev);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/updateReview")
    public ResponseEntity<String> editReview(@RequestParam Long reviewId, @RequestParam String reviewDetails) {
        boolean updateSuccess = reviewService.updateReviewStatus(reviewId, reviewDetails);

        if (updateSuccess) {

            return ResponseEntity.ok().body("{\"message\": \"Review status updated successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update review status.");
        }
    }
    @GetMapping("/review")
    public ResponseEntity<List<Review>> getAllReview() {
        List<Review> allReview = reviewService.getAllReview();
        return ResponseEntity.ok(allReview);
    }
    @PostMapping ("/reviewByid")
    public ResponseEntity<Optional<Review>> getReviewById(@RequestParam long id)
    {
        Optional<Review> idReview = reviewService.getReview(id);
        return ResponseEntity.ok(idReview);
    }



}
