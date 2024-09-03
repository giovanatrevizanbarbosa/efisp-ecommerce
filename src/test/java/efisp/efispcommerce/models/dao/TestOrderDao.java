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

    static UUID userId;
    static UUID cartId;
    static UUID addressId;

    @BeforeAll
    public static void setUp(){
        userId = UUID.randomUUID();
        userIDao.add(new User(userId, "Cauã", "a@a.com", "123"));

        cartId = UUID.randomUUID();
        cartIDao.add(new Cart(cartId, "a@a.com"));

        addressId = UUID.randomUUID();
        addressIDao.add(new Address(addressId, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
    }

    @Override
    @Test
    public void add() {
        assertTrue(orderIDao.add(new Order(UUID.randomUUID(), userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId))));
    }

    @Override
    @Test
    public void update() {
        UUID id = UUID.randomUUID();

        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        Order order2 = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        assertTrue(orderIDao.update(id, order2));
    }

    @Override
    @Test
    public void delete() {
        UUID id = UUID.randomUUID();

        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        assertTrue(orderIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        UUID id = UUID.randomUUID();
        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        assertEquals(order.getPaymentMethod(), orderIDao.getById(id).getPaymentMethod());
    }

    @Override
    @Test
    public void getAll() {
        var expected = orderIDao.getAll().size() + 1;

        Order order = new Order(UUID.randomUUID(), userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        var actual = orderIDao.getAll().size();

        assertEquals(expected, actual);
    }
}
