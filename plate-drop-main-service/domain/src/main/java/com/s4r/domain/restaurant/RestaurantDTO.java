package com.s4r.domain.restaurant;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class RestaurantDTO {

    private Long id;
    @NotNull
    private String name;
    private String cuisine;
    private String description;
    private String imageUrl;
    private BigDecimal rating;

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id) {
        this.id = id;
    }

    public RestaurantDTO(Long id, String name, String cuisine, String description, String imageUrl, BigDecimal rating) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    public static RestaurantDTO ofEntity(Restaurant restaurant) {
        var restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setCuisine(restaurant.getCuisine());
        restaurantDTO.setDescription(restaurant.getDescription());
        restaurantDTO.setImageUrl(restaurant.getImageUrl());
        restaurantDTO.setRating(restaurant.getRating());
        return restaurantDTO;
    }

    public static Restaurant toEntity(RestaurantDTO restaurantDTO) {
        var restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCuisine(restaurantDTO.getCuisine());
        restaurant.setDescription(restaurantDTO.getDescription());
        restaurant.setImageUrl(restaurantDTO.getImageUrl());
        restaurant.setRating(restaurantDTO.getRating());
        return restaurant;
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