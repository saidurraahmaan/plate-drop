package com.s4r.business.service.restaurant;

import com.s4r.domain.menuitem.MenuItemDTO;
import com.s4r.domain.restaurant.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    void addRestaurant(RestaurantDTO restaurant);

    List<RestaurantDTO> getUserRestaurants();

    void updateRestaurant(RestaurantDTO restaurant);

    void deleteRestaurant(Long id);

    RestaurantDTO getRestaurantById(Long id);

    void addRestaurantItem(MenuItemDTO restaurantItem);
}
