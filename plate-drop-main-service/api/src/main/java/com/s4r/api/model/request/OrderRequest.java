package com.s4r.api.model.request;

import com.s4r.domain.enums.OrderStatus;
import com.s4r.domain.menuitem.MenuItemDTO;
import com.s4r.domain.order.OrderDTO;

import java.util.List;

public class OrderRequest {
    private int restaurantId;
    List<Long> menuItems;

    public OrderRequest(int restaurantId, List<Long> menuItems) {
        this.restaurantId = restaurantId;
        this.menuItems = menuItems;
    }

    public static OrderDTO toOrderDTO(OrderRequest orderRequest) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setRestaurantId(orderRequest.getRestaurantId());
        orderDTO.setStatus(OrderStatus.PENDING);
        orderDTO.setOrderItems(orderRequest.menuItems.stream().map(MenuItemDTO::new).toList());
        return orderDTO;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Long> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Long> menuItems) {
        this.menuItems = menuItems;
    }
}
