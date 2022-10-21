package com.safinalproject.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {
    @Id
    private String id;
    private Long customerId;
    private String user;
    private Long vin;
    @Size(min = 1, max = 10, message = "Between the range 1-10")
    private int rating;
    @NotEmpty(message = "Between the range 1-10")
    private String comment;
    private Long average;

}
