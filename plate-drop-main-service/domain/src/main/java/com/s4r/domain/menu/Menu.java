package com.s4r.domain.menu;

import com.s4r.domain.menuitem.MenuItem;
import com.s4r.domain.restaurant.Restaurant;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(Long id, String name, Restaurant restaurant, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.menuItems = menuItems;
    }

    public Menu(Long id) {
        this.id = id;
    }

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
