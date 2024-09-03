package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderDao implements TestDao {

    IDao<Order> orderIDao = Dao.getInstance(Order.class);
    static IDao<User> userIDao = Dao.getInstance(User.class);
    static IDao<Cart> cartIDao = Dao.getInstance(Cart.class);
    static IDao<Address> addressIDao = Dao.getInstance(Address.class);


    static User user;
    static Cart cart;
    static Address address;

    @BeforeAll
    public static void setUp(){
        user = new User(UUID.randomUUID(), "Cauã", "a@a.com", "123");
        userIDao.add(user);

        cart = new Cart(UUID.randomUUID(), user.getEmail());
        cartIDao.add(cart);

        address = new Address(UUID.randomUUID(), "Rua", "123", "Cidaede", "Estado", "12345-123");
        addressIDao.add(address);
    }

    @Override
    @Test
    public void add() {
        assertTrue(orderIDao.add(new Order(UUID.randomUUID(), user, cart, PaymentMethod.CreditCard, address)));
    }

    @Override
    @Test
    public void update() {
        UUID id = UUID.randomUUID();

        Order order = new Order(id, user, cart, PaymentMethod.CreditCard, address);

        orderIDao.add(order);

        Order order2 = new Order(id, user, cart, PaymentMethod.CreditCard, address);

        assertTrue(orderIDao.update(id, order2));
    }

    @Override
    @Test
    public void delete() {
        UUID id = UUID.randomUUID();

        Order order = new Order(id, user, cart, PaymentMethod.CreditCard, address);

        orderIDao.add(order);

        assertTrue(orderIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        UUID id = UUID.randomUUID();
        Order order = new Order(id, user, cart, PaymentMethod.CreditCard, address);

        orderIDao.add(order);

        assertEquals(order.getPaymentMethod(), orderIDao.getById(id).getPaymentMethod());
    }

    @Override
    @Test
    public void getAll() {
        var expected = orderIDao.getAll().size() + 1;

        Order order = new Order(UUID.randomUUID(), user, cart, PaymentMethod.CreditCard, address);
        orderIDao.add(order);

        var actual = orderIDao.getAll().size();

        assertEquals(expected, actual);
    }
}
