package com.s4r.persistence.restaurant;

import com.s4r.domain.restaurant.Restaurant;
import com.s4r.domain.restaurant.RestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findAllByOwnerId(Long ownerId);
}