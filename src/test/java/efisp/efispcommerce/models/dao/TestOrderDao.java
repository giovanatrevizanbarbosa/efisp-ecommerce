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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderDao implements TestDao {

    IDao<Order> orderIDao = Dao.getInstance(Order.class);
    static IDao<User> userIDao = Dao.getInstance(User.class);
    static IDao<Cart> cartIDao = Dao.getInstance(Cart.class);
    static IDao<Address> addressIDao = Dao.getInstance(Address.class);

    static Long userId;
    static Long cartId;
    static Long addressId;

    @BeforeAll
    public static void setUp(){
        userId = userIDao.getNextId();
        userIDao.add(new User(userId, "Cauã", "a@a.com", "123"));

        cartId = cartIDao.getNextId();
        cartIDao.add(new Cart(cartId, "a@a.com"));

        addressId = addressIDao.getNextId();
        addressIDao.add(new Address(addressId, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
    }

    @Override
    @Test
    public void add() {
        assertTrue(orderIDao.add(new Order(orderIDao.getNextId(), userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId))));
    }

    @Override
    @Test
    public void update() {
        Long id = orderIDao.getNextId();

        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        Order order2 = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        assertTrue(orderIDao.update(id, order2));
    }

    @Override
    @Test
    public void delete() {
        Long id = orderIDao.getNextId();

        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        assertTrue(orderIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        Long id = orderIDao.getNextId();
        Order order = new Order(id, userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        assertEquals(order.getPaymentMethod(), orderIDao.getById(id).getPaymentMethod());
    }

    @Override
    @Test
    public void getAll() {
        var expected = orderIDao.getAll().size() + 1;

        Order order = new Order(orderIDao.getNextId(), userIDao.getById(userId), cartIDao.getById(cartId), PaymentMethod.CreditCard, addressIDao.getById(addressId));

        orderIDao.add(order);

        var actual = orderIDao.getAll().size();

        assertEquals(expected, actual);
    }
}
