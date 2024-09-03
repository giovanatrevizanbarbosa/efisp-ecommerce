package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDao implements TestDao {

    IDao<User> userIDao = Dao.getInstance(User.class);

    @Override
    @Test
    public void add() {
        assertTrue(userIDao.add(new User(UUID.randomUUID(), "Cauã", "caua.email.com", "Password123")));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();
        User user = new User(id, "Cauã", "caua.email.com", "Password123");

        userIDao.add(user);

        assertEquals(user.getName(), userIDao.getById(id).getName());
    }

    @Override
    @Test
    public void getAll() {
        var expected = userIDao.getAll().size() + 1;

        User user = new User(UUID.randomUUID(), "Cauã", "caua.email.com", "Password123");

        userIDao.add(user);

        var actual = userIDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();
        User user = new User(id, "Cauã", "caua.email.com", "Password123");

        userIDao.add(user);

        User user2 = new User(id, "João", "joao.email.com", "Password123");

        assertTrue(userIDao.update(id, user2));
    }

    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();

        User user = new User(id, "Cauã", "caua.email.com", "Password123");
        userIDao.add(user);

        assertTrue(userIDao.delete(id));
    }
}
