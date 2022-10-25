package com.safinalproject.review.controller;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validation;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewService.saveReview(reviewDto));
    }

    @GetMapping("/average/{vehicleId}")
    public ResponseEntity<?> getAverage(@PathVariable String vehicleId) {

        return ResponseEntity.ok(reviewService.getTheAverage(vehicleId));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<?> getVehicleById(@PathVariable String vehicleId) {
        return ResponseEntity.ok(reviewService.getReviewsByVehicleId(vehicleId));
    }
}
