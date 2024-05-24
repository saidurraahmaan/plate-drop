package com.s4r.domain.menuitem;

import com.s4r.domain.restaurant.Restaurant;
import com.s4r.domain.restaurant.RestaurantDTO;

public class MenuItemDTO {

    private Long id;
    private RestaurantDTO restaurant;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    public MenuItemDTO() {
    }

    public MenuItemDTO(Long id) {
        this.id = id;
    }

    public MenuItemDTO(Long id, RestaurantDTO restaurant, String name, String description, Double price, String imageUrl) {
        this.id = id;
        this.restaurant = restaurant;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public static MenuItemDTO ofEntity(MenuItem menuItem) {
        var menuItemDTO = new MenuItemDTO();
        menuItemDTO.setId(menuItem.getId());
        menuItemDTO.setName(menuItem.getName());
        menuItemDTO.setDescription(menuItem.getDescription());
        menuItemDTO.setPrice(menuItem.getPrice());
        menuItemDTO.setImageUrl(menuItem.getImageUrl());
        return menuItemDTO;
    }


    public static MenuItem toEntity(MenuItemDTO menuItemDTO) {
        var menuItem = new MenuItem();
        menuItem.setId(menuItemDTO.getId());
        menuItem.setName(menuItemDTO.getName());
        menuItem.setDescription(menuItemDTO.getDescription());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setImageUrl(menuItemDTO.getImageUrl());
        var res = new Restaurant();
        res.setId(menuItemDTO.getRestaurant().getId());
        menuItem.setRestaurant(res);
        return menuItem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
