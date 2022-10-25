package com.safinalproject.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ReviewDto implements Serializable {

    private String id;
    private Long customerId;
    private String user;
    private String vehicleId;
    @Max(value = 10, message = "Maximum limit exceed {value}")
    @Min(value = 1, message = "Minimum limit {value} must be fulfilled")
    private int rating;
    @NotEmpty(message = "Comment is appreciated")
    private String comment;
}
