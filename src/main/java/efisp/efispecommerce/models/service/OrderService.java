package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.entitys.Order;

import java.util.LinkedList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new LinkedList<>();

    private Order mapOrderDTOToEntity(OrderDTO orderDTO) {
        return new Order(orderDTO.getId(), orderDTO.getUser(), orderDTO.getCart()
                , orderDTO.getPaymentMethod(), orderDTO.getAddress());
    }

    public boolean addOrder(OrderDTO orderDTO) {
        return orders.add(mapOrderDTOToEntity(orderDTO));
    }
}
