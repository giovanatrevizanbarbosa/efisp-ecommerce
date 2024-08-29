package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.service.OrderService;

public class OrderController {
    private final OrderService service;

    public OrderController() {
        service = new OrderService();
    }

    public boolean addOrder(OrderDTO orderDto) {
        return service.addOrder(orderDto);
    }
}
