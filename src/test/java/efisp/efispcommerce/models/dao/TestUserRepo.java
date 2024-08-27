package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserRepo {

    IRepository<User> userIRepository;

    public void Initialize(){
        userIRepository = new Repository<>(User.class);
    }

    @Test
    public void TestUserDaoAdd() {
        Initialize();

        User user = new User(1, "Cauã", "caua@email.com", "Password123");
        User user2 = new User(2, "João", "joaoa@email.com", "Password123");

        var bool = userIRepository.add(user);
        var bool2 = userIRepository.add(user2);
        var expected = userIRepository.getAll();

        assertTrue(bool);
        assertTrue(bool2);
        assertEquals(expected.getFirst().getId(), user.getId());

    }

    @Test
    public void TestUserDaoGetById() {
        Initialize();

        User user = new User(10, "Cauã", "caua@email.com", "Password123");
        User user2 = new User(22, "João", "jaoao@gmail.com", "Password123");

        userIRepository.add(user);
        userIRepository.add(user2);

        var actual = userIRepository.getById(10);

        assertEquals(user.getId(), actual.getId());
    }

    @Test
    public void TestUserDaoGetAll() {
        Initialize();

        User user = new User(1, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2, "João", "joao.email.com", "Password123");

        userIRepository.add(user);
        userIRepository.add(user2);

        var expected = 2;
        var actual = userIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(user, userIRepository.getAll().getFirst());
        assertEquals(user2, userIRepository.getAll().getLast());
    }

    @Test
    public void TestUserDaoDelete() {
        Initialize();

        User user = new User(1, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2, "João", "joao.email.com", "Password123");

        userIRepository.add(user);
        userIRepository.add(user2);

        var bool = userIRepository.delete(1);

        var expected = 1;
        var actual = userIRepository.getAll().size();

        var userRecived = userIRepository.getById(2);

        assertEquals(user2, userRecived);
        assertTrue(bool);
        assertEquals(expected, actual);
    }

    @Test
    public void TestUserDaoUpdate() {
        Initialize();

        User user = new User(1, "Cauã", "caua.email.com", "Password123");
        User user2 = new User(2, "João", "joao.email.com", "Password123");

        userIRepository.add(user);
        userIRepository.add(user2);

        User user3 = new User(5, "Giovana", "giovana.email.com", "Password1234");

        var bool = userIRepository.update(1, user3);

        var actual = userIRepository.getById(5);

        var old = userIRepository.getById(1);

        assertNull(old);
        assertTrue(bool);
        assertEquals(user3, actual);
    }


}
