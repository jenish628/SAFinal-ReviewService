package com.safinalproject.review.service;

import com.safinalproject.review.dto.ReviewDto;
import com.safinalproject.review.dto.ReviewResponseDto;
import com.safinalproject.review.dto.ReviewsForVehicle;
import com.safinalproject.review.entity.Review;
import com.safinalproject.review.exception.ReviewNotFoundException;
import com.safinalproject.review.mapper.ReviewMapper;
import com.safinalproject.review.repository.ReviewRepository;
import com.safinalproject.review.util.AppUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    @Cacheable("reviews")
    public List<ReviewResponseDto> getAll() {

        return  reviewRepository
                .findAll()
                .stream()
                .map(a -> toReviewDto(a))
                .collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = "reviews", allEntries = true )
    public Long saveReview(ReviewDto reviewDto) {
        if (reviewDto.getCustomerId()== null){
            reviewDto.setCustomerId(AppUtil.getCustomerId());
        }
        if(reviewDto.getVin()== null){
            reviewDto.setVin(AppUtil.getVin());
        }
        if(reviewDto.getUser()== null){
            reviewDto.setUser(AppUtil.getCurrentUser());
        }
        reviewRepository.save(toReviewEntity(reviewDto));
        return reviewDto.getCustomerId();
    }

    private Review toReviewEntity(ReviewDto reviewDto){
        return reviewMapper.toReviewEntity(reviewDto);
    }
    private ReviewResponseDto toReviewDto(Review review){
        return reviewMapper.toReviewDto(review);
    }

    private List<ReviewsForVehicle>toReviewListDto (List<Review> reviews){
        return reviewMapper.toReviewListDto(reviews);
    }

    @Override
    public List<ReviewsForVehicle> getReviewsByVehicleId(Long vin) {

        Optional<Review> review = reviewRepository.findByVin(vin);

        if(review.isEmpty()){
            throw new ReviewNotFoundException();
        }
        return toReviewListDto(reviewRepository.getAllByVin(vin));

    }

    @Override
    public Long getTheAverage() {
        return averageRating();
    }

    private Long averageRating(){
        Long noOfReviews = reviewRepository.noOfReview();
        Long sumOfReviews = reviewRepository.sumOfReviews();
        return sumOfReviews/noOfReviews;

    }


}
