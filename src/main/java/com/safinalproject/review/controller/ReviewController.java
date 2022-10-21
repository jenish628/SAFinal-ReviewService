package com.safinalproject.review.controller;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto){
        return ResponseEntity.ok(reviewService.saveReview(reviewDto));
    }

    @GetMapping("/average")
    public ResponseEntity<?> getAverage(){
        return ResponseEntity.ok(reviewService.getTheAverage());
//        return ResponseEntity.ok(2);
    }


    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long vin){
        return ResponseEntity.ok(reviewService.getReviewsByVehicleId(vin));
    }


}