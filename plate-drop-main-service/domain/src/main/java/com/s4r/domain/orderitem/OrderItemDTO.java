package com.s4r.domain.orderitem;

import com.s4r.domain.menuitem.MenuItemDTO;

public class OrderItemDTO {

    private Long id;
    private MenuItemDTO menuItemId;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, MenuItemDTO menuItemId) {
        this.id = id;
        this.menuItemId = menuItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuItemDTO getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(MenuItemDTO menuItemId) {
        this.menuItemId = menuItemId;
    }
}