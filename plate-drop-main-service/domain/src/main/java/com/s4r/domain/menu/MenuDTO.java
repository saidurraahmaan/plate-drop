package com.s4r.domain.menu;


import com.s4r.domain.menuitem.MenuItemDTO;

import java.util.List;

public class MenuDTO {
    private Long id;
    private String name;
    private Long restaurantId;
    private List<MenuItemDTO> menuItems;

    // Default constructor
    public MenuDTO() {
    }

    // Constructor with fields
    public MenuDTO(Long id, String name, Long restaurantId, List<MenuItemDTO> menuItems) {
        this.id = id;
        this.name = name;
        this.restaurantId = restaurantId;
        this.menuItems = menuItems;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }
}


