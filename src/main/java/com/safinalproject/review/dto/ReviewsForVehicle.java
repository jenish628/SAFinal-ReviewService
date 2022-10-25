package com.safinalproject.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewsForVehicle {
    private String user;
    private String vehicleId;
    private int rating;
    private String comment;
}
