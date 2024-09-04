package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.service.OrderService;

import java.util.List;
import java.util.UUID;

public class OrderController {
    private final OrderService service;

    public OrderController() {
        service = new OrderService();
    }

    public boolean add(OrderDTO orderDto) {
        return service.add(orderDto);
    }

    public boolean update(UUID id, OrderDTO orderDto) {
        return service.update(id, orderDto);
    }

    public boolean delete(UUID id) {
        return service.delete(id);
    }

    public OrderDTO get(UUID id) {
        return service.getById(id);
    }

    public List<OrderDTO> getAll() {
        return service.getAll();
    }

    public List<OrderDTO> getUserOrders(UUID userId) {
        return service.getUserOrders(userId);
    }

    public OrderDTO getUserOrder(UUID userId, UUID orderId) {
        return service.getUserOrder(userId, orderId);
    }

    public List<OrderDTO> getOrdersByPaymentMethod(String paymentMethod) {
        return service.getByPaymentMethod(paymentMethod);
    }

    public List<OrderDTO> getOrdersByAddress(String address) {
        return service.getByAddress(address);
    }
}
