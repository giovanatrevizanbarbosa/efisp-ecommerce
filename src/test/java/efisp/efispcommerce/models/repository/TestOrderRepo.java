package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderRepo implements TestRepo {

    IRepository<Order> orderIRepository = new Repository<>(Order.class);
    static IRepository<User> userIRepository = new Repository<>(User.class);
    static IRepository<Cart> cartIRepository = new Repository<>(Cart.class);
    static IRepository<Address> addressIRepository = new Repository<>(Address.class);

    @BeforeAll
    public static void setUp(){
        userIRepository.add(new User(1L, "Cauã", "a@a.com", "123"));
        userIRepository.add(new User(2L, "Igor", "i@i.com", "123"));

        cartIRepository.add(new Cart(1L, "a@a.com"));
        cartIRepository.add(new Cart(2L, "i@i.com"));

        addressIRepository.add(new Address(1L, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
        addressIRepository.add(new Address(2L, "Rua Yoki", 700, "Araraquara", "SP", "14800200"));
    }

    @Override
    @Test
    public void add() {
        assertTrue(orderIRepository.add(new Order(1L, userIRepository.getById(1L), cartIRepository.getById(1L), PaymentMethod.CreditCard, addressIRepository.getById(1L))));
        assertTrue(orderIRepository.add(new Order(2L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L))));
    }

    @Override
    @Test
    public void update() {
        orderIRepository.add(new Order(1L, userIRepository.getById(1L), cartIRepository.getById(1L), PaymentMethod.CreditCard, addressIRepository.getById(1L)));
        orderIRepository.add(new Order(2L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L)));

        Order order3 = new Order(3L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L));

        assertTrue(orderIRepository.update(1L, order3));
    }

    @Override
    @Test
    public void delete() {
        orderIRepository.add(new Order(1L, userIRepository.getById(1L), cartIRepository.getById(1L), PaymentMethod.CreditCard, addressIRepository.getById(1L)));
        orderIRepository.add(new Order(2L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L)));

        assertTrue(orderIRepository.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        orderIRepository.add(new Order(1L, userIRepository.getById(1L), cartIRepository.getById(1L), PaymentMethod.CreditCard, addressIRepository.getById(1L)));
        orderIRepository.add(new Order(2L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L)));

        var actual = orderIRepository.getById(2);

        assertEquals(2L, actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        orderIRepository.add(new Order(1L, userIRepository.getById(1L), cartIRepository.getById(1L), PaymentMethod.CreditCard, addressIRepository.getById(1L)));
        orderIRepository.add(new Order(2L, userIRepository.getById(2L), cartIRepository.getById(2L), PaymentMethod.CreditCard, addressIRepository.getById(2L)));

        var expected = 2;
        var actual = orderIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(1L, orderIRepository.getAll().getFirst().getId());
    }
}
