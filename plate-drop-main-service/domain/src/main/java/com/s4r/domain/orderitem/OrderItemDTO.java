package com.s4r.domain.orderitem;

public class OrderItemDTO {

    private Long id;
    private Long orderId;
    private Long menuItemId;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Long orderId, Long menuItemId) {
        this.id = id;
        this.orderId = orderId;
        this.menuItemId = menuItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }
}