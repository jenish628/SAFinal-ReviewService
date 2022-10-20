package com.safinalproject.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class ReviewDto {

    private String id;
    private Long customerId;
    private String user;
    private Long vin;
    @Min(value = 0)
    @Max(value = 10)
    private int rating;
    private String comment;
}
