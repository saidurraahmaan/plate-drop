package com.s4r.domain.restaurant;

import java.math.BigDecimal;

public class RestaurantDTO {

    private Long id;
    private String name;
    private String cuisine;
    private String description;
    private String imageUrl;
    private BigDecimal rating;

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String name, String cuisine, String description, String imageUrl, BigDecimal rating) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}