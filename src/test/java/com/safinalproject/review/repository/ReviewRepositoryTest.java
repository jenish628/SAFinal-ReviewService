package com.safinalproject.review.repository;

import com.safinalproject.review.entity.Review;
import com.safinalproject.review.util.AppUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void getAllByVin(){
        //given
        Long cus = AppUtil.getCustomerId();
        String user = AppUtil.getCurrentUser();
        String vNum = AppUtil.getVin();
        Review review = new Review(cus,user,vNum,4,"This is a vehicle");
        underTest.save(review);

        //when
        List<Review> reviews = underTest.findAllByVehicleId(vNum);
        Review review1 = reviews.get(0);

        //then
        assertThat(review).isEqualTo(review1);
    }

    @Test
    void DoesNotGetAllByVin(){
        String vin = "1234";
        //given
        Long cus = AppUtil.getCustomerId();
        String user = AppUtil.getCurrentUser();
        String vNum = AppUtil.getVin();
        Review review = new Review(cus,user,vNum,4,"This is a vehicle");
        underTest.save(review);

        //when
        List<Review> reviews = underTest.findAllByVehicleId(vin);
        Review review1 = reviews.get(0);

        //then
        assertThat(review).isEqualTo(review1);
    }
}