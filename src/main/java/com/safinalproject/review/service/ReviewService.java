package com.safinalproject.review.service;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.dto.ReviewResponseDto;
import com.safinalproject.review.dto.ReviewsForVehicle;

import java.util.List;

public interface ReviewService {

    List<ReviewResponseDto> getAll ();

    Long saveReview(ReviewDto reviewDto);

    List<ReviewsForVehicle> getReviewsByVehicleId(Long vin);

        Long getTheAverage();
}
