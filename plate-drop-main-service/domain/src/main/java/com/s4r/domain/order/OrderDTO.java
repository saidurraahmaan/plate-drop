package com.s4r.domain.order;

import com.s4r.domain.enums.OrderStatus;
import com.s4r.domain.menuitem.MenuItemDTO;

import java.util.List;

public class OrderDTO {

    private Long id;
    private Integer orderBy;
    private int restaurantId;
    private Double totalPrice;
    private OrderStatus status;
    private List<MenuItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id) {
        this.id = id;
    }

    public OrderDTO(Long id, Integer userId, int restaurantId, Double totalPrice, OrderStatus status, List<MenuItemDTO> orderItems) {
        this.id = id;
        this.orderBy = userId;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderItems = orderItems;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public List<MenuItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<MenuItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
