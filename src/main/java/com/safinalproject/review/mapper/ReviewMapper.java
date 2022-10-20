package com.safinalproject.review.mapper;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.dto.ReviewResponseDto;
import com.safinalproject.review.dto.ReviewsForVehicle;
import com.safinalproject.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ReviewMapper {

    Review toReviewEntity (ReviewDto reviewDto);

    ReviewResponseDto toReviewDto (Review review);

    List<ReviewsForVehicle> toReviewListDto(List<Review> reviews);
}
