package com.s4r.domain.order;

import com.s4r.domain.enums.OrderStatus;
import com.s4r.domain.restaurant.Restaurant;
import com.s4r.domain.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_by", nullable = false)
    private User orderBy;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

//    @Column(name = "created_at", nullable = false)
//    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @Column(name = "total_price", nullable = false,  precision = 2)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, User user, Restaurant restaurant, Double totalPrice, OrderStatus status) {
        this.id = id;
        this.orderBy = user;
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(User user) {
        this.orderBy = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
}

