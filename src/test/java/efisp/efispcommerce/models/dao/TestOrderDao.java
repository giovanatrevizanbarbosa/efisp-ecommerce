package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.OrderDao;
import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderDao {

    @Test
    public void TestOrderDaoAdd() {
        Dao<Order> orderDao = OrderDao.getInstance();

        Order order = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        boolean expected = true;
        boolean actual = orderDao.add(order);

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderDaoGetById() {
        Dao<Order> orderDao = OrderDao.getInstance();

        Order order = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        orderDao.add(order);

        Order actual = orderDao.getById(0);

        assertEquals(order.getUser().getName(), actual.getUser().getName());
    }

    @Test
    public void TestOrderDaoGetAll() {
        Dao<Order> orderDao = OrderDao.getInstance();

        Order order = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));
        Order order2 = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        orderDao.add(order);
        orderDao.add(order2);

        int expected = 2;
        int actual = orderDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderDaoDelete() {
        Dao<Order> orderDao = OrderDao.getInstance();

        Order order = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        orderDao.add(order);

        boolean expected = true;
        boolean actual = orderDao.delete(0);

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderDaoUpdate() {
        Dao<Order> orderDao = OrderDao.getInstance();

        Order order = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        orderDao.add(order);

        Order order2 = new Order(new User("João", "email.com", "123456"), new Cart("email.com"), PaymentMethod.Pix, new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200"));

        boolean expected = true;
        boolean actual = orderDao.update(0, order2);

        assertEquals(expected, actual);
    }
}
