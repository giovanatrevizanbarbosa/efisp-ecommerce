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

    IDao<Order> orderIDao = new Dao<>(Order.class);
    static IDao<User> userIDao = new Dao<>(User.class);
    static IDao<Cart> cartIDao = new Dao<>(Cart.class);
    static IDao<Address> addressIDao = new Dao<>(Address.class);

    @BeforeAll
    public static void setUp(){
        userIDao.add(new User(1L, "Cauã", "a@a.com", "123"));
        userIDao.add(new User(2L, "Igor", "i@i.com", "123"));

        cartIDao.add(new Cart(1L, "a@a.com"));
        cartIDao.add(new Cart(2L, "i@i.com"));

        addressIDao.add(new Address(1L, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
        addressIDao.add(new Address(2L, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
    }

    @Override
    @Test
    public void add() {
        assertTrue(orderIDao.add(new Order(1L, userIDao.getById(1L), cartIDao.getById(1L), PaymentMethod.CreditCard, addressIDao.getById(1L))));
        assertTrue(orderIDao.add(new Order(2L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L))));
    }

    @Override
    @Test
    public void update() {
        orderIDao.add(new Order(1L, userIDao.getById(1L), cartIDao.getById(1L), PaymentMethod.CreditCard, addressIDao.getById(1L)));
        orderIDao.add(new Order(2L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L)));

        Order order3 = new Order(3L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L));

        assertTrue(orderIDao.update(1L, order3));
    }

    @Override
    @Test
    public void delete() {
        orderIDao.add(new Order(1L, userIDao.getById(1L), cartIDao.getById(1L), PaymentMethod.CreditCard, addressIDao.getById(1L)));
        orderIDao.add(new Order(2L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L)));

        assertTrue(orderIDao.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        orderIDao.add(new Order(1L, userIDao.getById(1L), cartIDao.getById(1L), PaymentMethod.CreditCard, addressIDao.getById(1L)));
        orderIDao.add(new Order(2L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L)));

        var actual = orderIDao.getById(2);

        assertEquals(2L, actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        orderIDao.add(new Order(1L, userIDao.getById(1L), cartIDao.getById(1L), PaymentMethod.CreditCard, addressIDao.getById(1L)));
        orderIDao.add(new Order(2L, userIDao.getById(2L), cartIDao.getById(2L), PaymentMethod.CreditCard, addressIDao.getById(2L)));

        var expected = 2;
        var actual = orderIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(1L, orderIDao.getAll().getFirst().getId());
    }
}
