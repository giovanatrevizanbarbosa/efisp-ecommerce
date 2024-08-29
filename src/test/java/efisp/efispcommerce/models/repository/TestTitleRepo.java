package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTitleRepo implements TestRepo{

    IRepository<Title> titleIRepository = new Repository<>(Title.class);

    @Override
    @Test
    public void add() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        assertTrue(titleIRepository.add(title));
        assertTrue(titleIRepository.add(title2));
        assertFalse(titleIRepository.add(title));
        assertEquals(titleIRepository.getAll().getFirst().getId(), title.getId());
    }

    @Override
    @Test
    public void getById() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIRepository.add(title);
        titleIRepository.add(title2);

        var actual = titleIRepository.getById(2);
        assertEquals(title2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIRepository.add(title);
        titleIRepository.add(title2);

        var expected = 2;
        var actual = titleIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(title, titleIRepository.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIRepository.add(title);
        titleIRepository.add(title2);

        Title title3 = new Title(3L, "GUEST", 3);

        assertTrue(titleIRepository.update(1L, title3));
    }

    @Override
    @Test
    public void delete() {
        Title title = new Title(1L, "ADMIN", 1);
        Title title2 = new Title(2L, "USER", 2);

        titleIRepository.add(title);
        titleIRepository.add(title2);

        assertTrue(titleIRepository.delete(1L));
    }
}
