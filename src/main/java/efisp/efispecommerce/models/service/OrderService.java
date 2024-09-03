package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private final IDao<Order> dao = Dao.getInstance(Order.class);
    private final UserService userService = new UserService();
    private final CartService cartService = new CartService();
    private final AddressService addressService = new AddressService();

    private Order toEntity(OrderDTO orderDTO) {
        return new Order(orderDTO.id(), userService.toEntity(orderDTO.user()), cartService.toEntity(orderDTO.cart())
                , orderDTO.paymentMethod(), addressService.toEntity(orderDTO.address()));
    }

    private OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getId(), userService.toDTO(order.getUser()), cartService.toDTO(order.getCart())
                , order.getPaymentMethod(), addressService.toDTO(order.getAddress()));
    }

    public boolean addOrder(OrderDTO orderDTO) {
        return dao.add(toEntity(orderDTO));
    }

    public List<OrderDTO> getOrders() {
        List<OrderDTO> orderDTOs = new LinkedList<>();
        for (Order order : dao.getAll()) {
            orderDTOs.add(toDTO(order));
        }
        return orderDTOs;
    }


    public OrderDTO getUserOrder(UUID userId, UUID orderId) {
        for (Order order : dao.getAll()) {
            if (order.getUser().getId().equals(userId) && order.getId().equals(orderId)) {
                return toDTO(order);
            }
        }

        return null;
    }

    public List<OrderDTO> getUserOrders(UUID userId) {
        List<OrderDTO> userOrders = new LinkedList<>();
        for (Order order : dao.getAll()) {
            if (order.getUser().getId().equals(userId)) {
                userOrders.add(toDTO(order));
            }
        }

        return userOrders;
    }
}
