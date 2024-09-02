package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDao implements TestDao {

    IDao<User> userIDao;

    @BeforeEach
    public void Initialize(){
        userIDao = new Dao<>(User.class);
    }

    @Override
    @Test
    public void add() {
        User user = new User(1L, "Cauã", "caua@email.com", "Password123");
        User user2 = new User(2L, "João", "joaoa@email.com", "Password123");

        var bool = userIDao.add(user);
        var bool2 = userIDao.add(user2);
        var expected = userIDao.getAll();

        assertTrue(bool);
        assertTrue(bool2);
        assertEquals(expected.getFirst().getId(), user.getId());
    }

    @Override
    @Test
    public void getById() {
        User user = new User(10L, "Cauã", "caua@email.com", "Password123");
        User user2 = new User(22L, "João", "jaoao@gmail.com", "Password123");

        userIDao.add(user);
        userIDao.add(user2);

        var actual = userIDao.getById(10);

        assertEquals(user.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        User user = new User(1L, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2L, "João", "joao.email.com", "Password123");

        userIDao.add(user);
        userIDao.add(user2);

        var expected = 2;
        var actual = userIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(user, userIDao.getAll().getFirst());
        assertEquals(user2, userIDao.getAll().getLast());
    }

    @Override
    @Test
    public void update() {
        User user = new User(1L, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2L, "João", "joao.email.com", "Password123");

        userIDao.add(user);
        userIDao.add(user2);

        User user3 = new User(5L, "Giovana", "giovana.email.com", "Password1234");

        var bool = userIDao.update(1, user3);

        var actual = userIDao.getById(5);

        var old = userIDao.getById(1);

        assertNull(old);
        assertTrue(bool);
        assertEquals(user3, actual);
    }

    @Override
    @Test
    public void delete() {
        User user = new User(1L, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2L, "João", "joao.email.com", "Password123");

        userIDao.add(user);
        userIDao.add(user2);

        var bool = userIDao.delete(1);

        var expected = 1;
        var actual = userIDao.getAll().size();

        var userRecived = userIDao.getById(2);

        assertEquals(user2, userRecived);
        assertTrue(bool);
        assertEquals(expected, actual);
    }
}
