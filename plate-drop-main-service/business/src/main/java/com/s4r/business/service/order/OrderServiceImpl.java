package com.s4r.business.service.order;

import com.s4r.business.service.exception.ErrorCode;
import com.s4r.business.service.exception.ServiceException;
import com.s4r.domain.order.OrderDTO;
import com.s4r.persistence.restaurant.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final RestaurantRepository restaurantRepo;

    public OrderServiceImpl(RestaurantRepository restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }


    @Override
    public void placeOrder(OrderDTO order) {
        var restaurant = restaurantRepo.findById(order.getRestaurantId());
        if (restaurant.isEmpty()) {
            log.warn("Restaurant not exist for id: {}", order.getRestaurantId());
            throw new ServiceException(ErrorCode.USER_NOT_FOUND);
        }
        //check if all the menu items valid or not

    }
}
