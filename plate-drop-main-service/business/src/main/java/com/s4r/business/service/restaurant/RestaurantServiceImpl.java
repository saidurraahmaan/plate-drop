package com.s4r.business.service.restaurant;

import com.s4r.business.service.utils.ServiceUtils;
import com.s4r.domain.menuitem.MenuItemDTO;
import com.s4r.domain.restaurant.RestaurantDTO;
import com.s4r.domain.user.User;
import com.s4r.persistence.menuitem.MenuItemRepository;
import com.s4r.persistence.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepo;
    private final MenuItemRepository menuItemRepo;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepo) {
        this.restaurantRepo = restaurantRepository;
        this.menuItemRepo = menuItemRepo;
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
    public List<RestaurantDTO> getUserRestaurants() {
        var currentUser = ServiceUtils.getAuthenticatedUser();
        var result = restaurantRepo.findAllByOwnerId(currentUser.getId());
        return result.stream()
                .map(RestaurantDTO::ofEntity)
                .toList();
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

    @Override
    public void addRestaurantItem(MenuItemDTO restaurantItem) {
        //todo:check if the restaurant exist or not
        //todo:check if the the user is the owner or not
        menuItemRepo.save(MenuItemDTO.toEntity(restaurantItem));
    }
}
