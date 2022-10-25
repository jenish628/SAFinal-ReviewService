package com.safinalproject.review.service;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.dto.ReviewResponseDto;
import com.safinalproject.review.dto.ReviewsForVehicle;
import com.safinalproject.review.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewResponseDto> getAll();

    ReviewResponseDto saveReview(ReviewDto reviewDto);

    List<ReviewsForVehicle> getReviewsByVehicleId(String vehicleId);

    Long getTheAverage(String vehicleId);
    ReviewDto findById(String vehicleId);

}
