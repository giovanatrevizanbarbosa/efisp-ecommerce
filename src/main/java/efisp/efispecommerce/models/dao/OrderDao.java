package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.entitys.Order;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrderDao implements Dao<Order> {

    private static OrderDao instance;
    private final Map<Long, Order> orders;

    private OrderDao() {
        orders = new HashMap<>();
    }

    public static Dao<Order> getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    @Override
    public boolean add(Order order) {
        Order order1 = new Order(order.getUser(), order.getCart(), order.getPaymentMethod(), order.getAddress());
        return orders.put((long) orders.size(), order1) == null;
    }

    @Override
    public boolean update(long id, Order order) {
        Order order1 = new Order(order.getUser(), order.getCart(), order.getPaymentMethod(), order.getAddress());
        return orders.replace(id, order1) != null;

    }

    @Override
    public boolean delete(long id) {
        return orders.remove(id) != null;
    }

    @Override
    public Order getById(long id) {
        Order orderFinded = orders.get(id);

        if (orderFinded != null) {
            return new Order(orderFinded.getUser(), orderFinded.getCart(), orderFinded.getPaymentMethod(), orderFinded.getAddress());
        }

        throw new RuntimeException("Order not found");
    }

    @Override
    public List<Order> getAll() {
        List<Order> ordersList = new LinkedList<>();
        orders.values().forEach(order -> ordersList.add(new Order(order.getUser(), order.getCart(), order.getPaymentMethod(), order.getAddress())));
        return ordersList;
    }
}
