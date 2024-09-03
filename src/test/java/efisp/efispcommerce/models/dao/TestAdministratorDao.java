package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministratorDao implements TestDao {

    IDao<Administrator> administratorIDao = Dao.getInstance(Administrator.class);
    static IDao<Title> titleIDao = Dao.getInstance(Title.class);
    static UUID titleId = UUID.randomUUID();

    @BeforeAll
    public static void Initialize(){
        titleIDao.add(new Title(titleId, "ADMIN", 1));
    }

    @Override
    @Test
    public void add() {
        Administrator administrator = new Administrator(UUID.randomUUID(), "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));
        Administrator administrator2 = new Administrator(UUID.randomUUID(), "João", "joao.email.com", "Password123", titleIDao.getById(titleId));

        assertTrue(administratorIDao.add(administrator));
        assertTrue(administratorIDao.add(administrator2));
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();

        Administrator administrator = new Administrator(id, "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));

        administratorIDao.add(administrator);

        Administrator administrator2 = new Administrator(id, "João", "joao.email.com", "Password123",titleIDao.getById(titleId));

        assertTrue(administratorIDao.update(id, administrator2));
    }

    @Test
    public void TitleIdInAdministrator(){
        var id = UUID.randomUUID();

        Administrator administrator = new Administrator(id, "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));

        administratorIDao.add(administrator);

        assertEquals(titleId, administrator.getTitle().getId());
    }


    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();

        Administrator administrator = new Administrator(id, "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));

        administratorIDao.add(administrator);

        assertTrue(administratorIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();

        Administrator administrator = new Administrator(id, "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));

        administratorIDao.add(administrator);

        assertEquals(administrator, administratorIDao.getById(id));
    }

    @Override
    @Test
    public void getAll() {
        var expected = administratorIDao.getAll().size() + 1;

        Administrator administrator = new Administrator(UUID.randomUUID(), "Cauã", "caua.email.com", "Password123", titleIDao.getById(titleId));

        administratorIDao.add(administrator);

        var actual = administratorIDao.getAll().size();

        assertEquals(expected, actual);
    }

}
