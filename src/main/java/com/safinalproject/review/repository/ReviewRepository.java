package com.safinalproject.review.repository;

import com.safinalproject.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Long> {

//    @Query(value = "SELECT sum(rating)from Review ")
//    public Long sumOfReview();
//
//    @Query("select count(r) from Review r")
//    public Long noOfReview();

    @Query(value = "SELECT sum(rating)from Review ")
    public Long sumOfReviews();
    @Query("select count(r) from Review r")
    public Long noOfReview();

    public List<Review> getAllByVin(Long vin);

    Optional<Review> findByVin (Long vin);

}
