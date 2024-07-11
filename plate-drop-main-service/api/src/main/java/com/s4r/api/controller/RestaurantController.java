package com.s4r.api.controller;

import com.s4r.business.service.restaurant.RestaurantService;
import com.s4r.domain.menuitem.MenuItemDTO;
import com.s4r.domain.restaurant.RestaurantDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/all")
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.getUserRestaurants();
    }

    @PostMapping("/add")
    public void addRestaurant(@Valid @RequestBody RestaurantDTO restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    public void updateRestaurant(RestaurantDTO restaurant) {
        restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @PostMapping("/add/menu/{restaurantId}")
    public void addMenuItem(@PathVariable Integer restaurantId, @RequestBody MenuItemDTO menuItemDTO) {
        var s = new RestaurantDTO(restaurantId);
        menuItemDTO.setRestaurant(s);
        restaurantService.addRestaurantItem(menuItemDTO);
    }

}
