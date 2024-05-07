package com.s4r.api.controller;

import com.s4r.business.service.restaurant.RestaurantService;
import com.s4r.domain.restaurant.RestaurantDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/save")
    public void addRestaurant(@Valid RestaurantDTO restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    public void updateRestaurant(RestaurantDTO restaurant) {
        restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }

}
