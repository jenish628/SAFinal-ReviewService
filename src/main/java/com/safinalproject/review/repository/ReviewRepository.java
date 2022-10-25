package com.safinalproject.review.repository;

import com.safinalproject.review.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Long> {


//    @Query(value = "SELECT sum(rating)from Review ")
//    public Long sumOfReview();
//
//    @Query("select count(r) from Review r")
//    public Long noOfReview();

//    @Query(value = "SELECT sum(rating) from Review r where r.vehicleId=:vehicleId")
//    @Aggregation("{ '$group' : { '_id' : null, 'total' : { $sum: '$age' } } )




    @Query(value = "{vehicleId: ?0}", count = true)
    //SQL Equivalent : select count(*) from book where author=?
    public Long countAllByVehicleId(String vehicleId);


    public List<Review> findAllByVehicleId(String vehicleId);




}
