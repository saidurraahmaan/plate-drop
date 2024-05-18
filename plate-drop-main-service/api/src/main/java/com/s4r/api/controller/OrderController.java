package com.s4r.api.controller;

import com.s4r.business.service.order.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place-order")
    public void placeOrder(@RequestParam Long userId, @RequestParam Long orderId) {

    }

}
