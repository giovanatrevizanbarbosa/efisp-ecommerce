package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministratorDao implements TestDao {

    IDao<Administrator> administratorIDao = new Dao<>(Administrator.class);
    static IDao<Title> titleIDao = new Dao<>(Title.class);

    @BeforeAll
    public static void Initialize(){
        titleIDao.add(new Title(1L, "ADMIN", 1));
    }

    @Override
    @Test
    public void add() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIDao.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIDao.getAll().getFirst());

        assertTrue(administratorIDao.add(administrator));
        assertTrue(administratorIDao.add(administrator2));
        assertFalse(administratorIDao.add(administrator));
    }

    @Override
    @Test
    public void update() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIDao.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIDao.getAll().getFirst());

        administratorIDao.add(administrator);
        administratorIDao.add(administrator2);

        Administrator administrator3 = new Administrator(3L, "Kauam", "caua.email.com", "Password123", titleIDao.getAll().getFirst());

        assertTrue(administratorIDao.update(1L, administrator3));
    }

    @Override
    @Test
    public void delete() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIDao.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIDao.getAll().getFirst());

        administratorIDao.add(administrator);
        administratorIDao.add(administrator2);

        assertTrue(administratorIDao.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIDao.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIDao.getAll().getFirst());

        administratorIDao.add(administrator);
        administratorIDao.add(administrator2);

        var actual = administratorIDao.getById(2L);
        assertEquals(administrator2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIDao.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIDao.getAll().getFirst());

        administratorIDao.add(administrator);
        administratorIDao.add(administrator2);

        var expected = 2;
        var actual = administratorIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(administrator, administratorIDao.getAll().getFirst());
        assertEquals(administrator2, administratorIDao.getAll().getLast());
    }

}
