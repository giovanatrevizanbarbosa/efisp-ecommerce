package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.UserDao;
import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestUserDao {

    Dao<User> userDao;

    public void Initialize() {
        userDao = UserDao.getInstance();

        for (int i = 0; i < userDao.getAll().size(); i++) {
            userDao.delete(i);
        }
    }

    @Test
    public void TestUserDaoGetById() {
        Initialize();

        User user = new User(
                "João",
                "joao@gmail.com",
                "123456"
        );

        userDao.add(user);

        User actual = userDao.getById(0);

        assertEquals(user.getEmail(), actual.getEmail());

        try {
            userDao.getById(1);
        } catch (RuntimeException e) {
            assertEquals("User not found", e.getMessage());
        }

    }

    @Test
    public void TestUserDaoAdd() {
        Initialize();

        User user = new User(
                "João",
                "joao@gmail.com",
                "123456"
        );

        boolean expected = true;
        boolean actual = userDao.add(user);

        assertEquals(expected, actual);
    }

    @Test
    public void TestUserDaoUpdate() {
        Initialize();

        User user = new User(
                "João",
                "joao@gmail.com",
                "123456"
        );

        userDao.add(user);

        User user1 = new User(
                "João",
                "joa2@gmail.com",
                "123456");

        boolean expected = true;
        boolean actual = userDao.update(0, user1);

        assertEquals(expected, actual);
        assertEquals(user1.getEmail(), userDao.getById(0).getEmail());
    }

    @Test
    public void TestUserDaoDelete() {
        Initialize();

        User user = new User(
                "João",
                "joao@gmail.com",
                "123456"
        );

        userDao.add(user);

        boolean expected = true;
        boolean actual = userDao.delete(0);

        assertEquals(expected, actual);

        try {
            userDao.getById(0);
        } catch (RuntimeException e) {
            assertEquals("User not found", e.getMessage());
        }
    }



    @Test
    public void TestUserDaoGetAll() {
        Initialize();

        User user = new User(
                "João",
                "joao@gmail.com",
                "123456"
        );

        userDao.add(user);

        assertEquals(user.getEmail(), userDao.getAll().get(0).getEmail());
        assertEquals(1, userDao.getAll().size());

    }

    @Test
    public void TestUserDaoGetInstance() {
        Initialize();

        assertEquals(userDao, UserDao.getInstance());
    }
}
