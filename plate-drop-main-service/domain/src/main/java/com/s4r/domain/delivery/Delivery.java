package com.s4r.domain.delivery;

import com.s4r.domain.enums.DeliveryStatus;
import com.s4r.domain.order.Order;
import com.s4r.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "delivery_time", nullable = false)
    private LocalDateTime deliveryTime;

    @ManyToOne
    @JoinColumn(name = "delivered_by_user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_delivery_user"))
    private User deliveredBy;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_delivery_order"))
    private Order order;

    // Constructors, getters and setters
    public Delivery() {
    }

    public Delivery(Long id) {
        this.id = id;
    }

    public Delivery(String deliveryAddress, DeliveryStatus deliveryStatus, LocalDateTime deliveryTime, User deliveryPersonName, Order order) {
        this.deliveryAddress = deliveryAddress;
        this.deliveryStatus = deliveryStatus;
        this.deliveryTime = deliveryTime;
        this.deliveredBy = deliveryPersonName;
        this.order = order;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public User getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(User deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
