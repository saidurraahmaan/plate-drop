package com.s4r.domain.restaurant;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "location", nullable = false)
//    @Convert(converter = PointConverter.class) // Assuming a PointConverter class
//    private Point location;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating", scale = 1, precision = 2)
    private BigDecimal rating;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String cuisine, String description, String imageUrl, BigDecimal rating) {
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
