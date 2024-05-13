package com.s4r.domain.order;

import com.s4r.domain.enums.OrderStatus;
import com.s4r.domain.orderitem.OrderItemDTO;

import java.util.List;

public class OrderDTO {

    private Long id;
    private Integer orderBy;
    private Long restaurantId;
    private Double totalPrice;
    private OrderStatus status;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Integer userId, Long restaurantId, Double totalPrice, OrderStatus status, List<OrderItemDTO> orderItems) {
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
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


    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
