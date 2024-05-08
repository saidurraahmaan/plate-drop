package com.s4r.business.service.restaurant;

import com.s4r.business.service.utils.ServiceUtils;
import com.s4r.domain.restaurant.RestaurantDTO;
import com.s4r.domain.user.User;
import com.s4r.persistence.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepo;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepo = restaurantRepository;
    }

    @Override
    @Transactional
    public void addRestaurant(RestaurantDTO restaurant) {
        var user = ServiceUtils.getAuthenticatedUser();
        var restaurantEntity = RestaurantDTO.toEntity(restaurant);
        var owner = new User();
        owner.setId(user.getId());
        restaurantEntity.setOwner(owner);
        restaurantRepo.save(restaurantEntity);
    }

    @Override
    @Transactional
    public void updateRestaurant(RestaurantDTO restaurant) {
        restaurantRepo.save(RestaurantDTO.toEntity(restaurant));
    }

    @Override
    public void deleteRestaurant(Long id) {

    }

    @Override
    public RestaurantDTO getRestaurantById(Long id) {
        return null;
    }
}
