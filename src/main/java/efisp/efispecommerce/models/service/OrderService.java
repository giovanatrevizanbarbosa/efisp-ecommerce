package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private final IDao<Order> dao = Dao.getInstance(Order.class);
    private final UserService userService = new UserService();
    private final ItemService cartService = new ItemService();
    private final AddressService addressService = new AddressService();

    private Order toEntity(OrderDTO orderDTO) {
        return new Order(orderDTO.id(), userService.toEntity(orderDTO.user()), orderDTO.items()
                , orderDTO.paymentMethod(), addressService.toEntity(orderDTO.address()));
    }

    private OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getId(), userService.toDTO(order.getUser()), order.getItems()
                , order.getPaymentMethod(), addressService.toDTO(order.getAddress()));
    }

    public boolean add(OrderDTO orderDTO) {
        return dao.add(toEntity(orderDTO));
    }


    public List<OrderDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
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

    public boolean update(UUID id, OrderDTO orderDto) {
        return dao.update(id, toEntity(orderDto));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public OrderDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }

    public List<OrderDTO> getByPaymentMethod(String paymentMethod) {
        return dao.getAll().stream().filter(p -> p.getPaymentMethod().equals(PaymentMethod.valueOf(paymentMethod))).map(this::toDTO).toList();
    }

    public List<OrderDTO> getByAddress(String address) {
        return dao.getAll().stream().filter(p -> p.getAddress().getStreet().contains(address)).map(this::toDTO).toList();
    }

}
