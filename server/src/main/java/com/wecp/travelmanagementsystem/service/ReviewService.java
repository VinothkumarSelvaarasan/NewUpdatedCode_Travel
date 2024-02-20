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
        return reviewRepository.save(review);
    }

    public boolean updateReviewStatus(Long reviewId, String reviewDetails) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + reviewId));

        review.setReviewDetails(reviewDetails);
        try {
            reviewRepository.save(review);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReview(Long id) {
        return reviewRepository.findById(id);
    }
}
