package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.CartDao;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.entitys.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartDao {

    @Test
    public void TestCartDaoAdd() {
        Dao<Cart> cartDao = CartDao.getInstance();

        Cart cart = new Cart(1, "email.com");

        boolean expected = true;
        boolean actual = cartDao.add(cart);

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartDaoGetById() {
        Dao<Cart> cartDao = CartDao.getInstance();

        Cart cart = new Cart(1, "email.com");

        cartDao.add(cart);

        Cart actual = cartDao.getById(0);

        assertEquals(cart.getOwnerEmail(), actual.getOwnerEmail());
    }

    @Test
    public void TestCartDaoGetAll() {
        Dao<Cart> cartDao = CartDao.getInstance();

        Cart cart = new Cart(1, "email.com");
        Cart cart2 = new Cart(2, "email.com");

        cartDao.add(cart);
        cartDao.add(cart2);

        int expected = 2;
        int actual = cartDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartDaoDelete() {
        Dao<Cart> cartDao = CartDao.getInstance();

        Cart cart = new Cart(1, "email.com");
        cartDao.add(cart);

        boolean expected = true;
        boolean actual = cartDao.delete(0);

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartDaoUpdate() {
        Dao<Cart> cartDao = CartDao.getInstance();

        Cart cart = new Cart(1, "email.com");
        cartDao.add(cart);

        boolean expected = true;
        boolean actual = cartDao.update(0, cart);

        assertEquals(expected, actual);
    }
}
