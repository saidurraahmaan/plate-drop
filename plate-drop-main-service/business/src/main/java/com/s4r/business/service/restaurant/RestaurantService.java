package com.s4r.business.service.restaurant;

import com.s4r.domain.restaurant.RestaurantDTO;

public interface RestaurantService {
    void addRestaurant(RestaurantDTO restaurant);

    void updateRestaurant(RestaurantDTO restaurant);

    void deleteRestaurant(Long id);

    RestaurantDTO getRestaurantById(Long id);
}
