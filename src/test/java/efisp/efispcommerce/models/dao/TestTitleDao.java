package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTitleDao implements TestDao {

    IDao<Title> titleIDao = new Dao<>(Title.class);

    @Override
    @Test
    public void add() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        assertTrue(titleIDao.add(title));
        assertTrue(titleIDao.add(title2));
        assertFalse(titleIDao.add(title));
        assertEquals(titleIDao.getAll().getFirst().getId(), title.getId());
    }

    @Override
    @Test
    public void getById() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIDao.add(title);
        titleIDao.add(title2);

        var actual = titleIDao.getById(2);
        assertEquals(title2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIDao.add(title);
        titleIDao.add(title2);

        var expected = 2;
        var actual = titleIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(title, titleIDao.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIDao.add(title);
        titleIDao.add(title2);

        Title title3 = new Title(3L, "GUEST", 3);

        assertTrue(titleIDao.update(1L, title3));
    }

    @Override
    @Test
    public void delete() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIDao.add(title);
        titleIDao.add(title2);

        assertTrue(titleIDao.delete(1L));
    }
}
