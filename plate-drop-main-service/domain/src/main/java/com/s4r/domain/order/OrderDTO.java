package com.s4r.domain.order;

import com.s4r.domain.enums.OrderStatus;

import java.math.BigDecimal;

public class OrderDTO {

    private Long id;
    private Long userId;
    private Long restaurantId;
    private BigDecimal totalPrice;
    private OrderStatus status;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long userId, Long restaurantId, BigDecimal totalPrice, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
