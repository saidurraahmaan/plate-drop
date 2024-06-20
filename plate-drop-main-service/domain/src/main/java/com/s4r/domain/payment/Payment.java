package com.s4r.domain.payment;

import com.s4r.domain.order.Order;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "payment_on", nullable = false)
    private LocalDateTime paymentOn;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true,foreignKey = @ForeignKey(name = "fk_payment_order_id"))
    private Order order;

    // Constructors, getters and setters
    public Payment() {
    }

    public Payment(Long id) {
        this.id = id;
    }

    public Payment(Double amount, LocalDateTime paymentDate, String status, Order order) {
        this.amount = amount;
        this.paymentOn = paymentDate;
        this.order = order;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentOn() {
        return paymentOn;
    }

    public void setPaymentOn(LocalDateTime paymentOn) {
        this.paymentOn = paymentOn;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
