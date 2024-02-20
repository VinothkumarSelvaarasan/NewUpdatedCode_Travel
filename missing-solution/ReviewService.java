package com.wecp.travelmanagementsystem.service;

import com.wecp.travelmanagementsystem.entity.Review;
import com.wecp.travelmanagementsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(Review review)
    {
       //Complete the Code
    }

    public boolean updateReviewStatus(Long reviewId, String reviewDetails) {
        //Complete the Code
    }

    public List<Review> getAllReview() {
        //Complete the Code
    }

    public Optional<Review> getReview(Long id) {
       //Complete the Code
    }
}
