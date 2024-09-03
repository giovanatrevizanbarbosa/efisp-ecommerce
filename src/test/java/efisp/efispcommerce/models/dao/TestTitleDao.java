package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestTitleDao implements TestDao {

    IDao<Title> titleIDao = Dao.getInstance(Title.class);

    @Override
    @Test
    public void add() {
        assertTrue(titleIDao.add(new Title(UUID.randomUUID(), "ADMIN", 1)));
        assertTrue(titleIDao.add(new Title(UUID.randomUUID(), "USER", 2)));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();
        Title title = new Title(id, "ADMIN", 1);

        titleIDao.add(title);

        assertEquals(title.getName(), titleIDao.getById(id).getName());
    }

    @Override
    @Test
    public void getAll() {
        var expected = titleIDao.getAll().size() + 1;

        Title title = new Title(UUID.randomUUID(), "ADMIN", 1);

        titleIDao.add(title);

        var actual = titleIDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();
        Title title = new Title(id, "ADMIN", 1);

        titleIDao.add(title);

        Title title2 = new Title(id, "USER", 2);

        assertTrue(titleIDao.update(id, title2));
    }

    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();
        Title title = new Title(id, "ADMIN", 1);

        titleIDao.add(title);

        assertTrue(titleIDao.delete(id));
    }
}
