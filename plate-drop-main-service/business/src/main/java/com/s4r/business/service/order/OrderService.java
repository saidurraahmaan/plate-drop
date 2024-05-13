package com.s4r.business.service.order;

import com.s4r.domain.order.OrderDTO;

public interface OrderService {
    void placeOrder(OrderDTO order);
}
