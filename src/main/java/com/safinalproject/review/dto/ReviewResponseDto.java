package com.safinalproject.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ReviewResponseDto implements Serializable {
    private String id;
    private Long customerId;
    private String user;
    private Long vin;
    private int rating;
    private String comment;
    private Long average;

    public Long getAverage() {
        return average;
    }

    public void setAverage(Long average) {
        this.average = average;
    }
}
