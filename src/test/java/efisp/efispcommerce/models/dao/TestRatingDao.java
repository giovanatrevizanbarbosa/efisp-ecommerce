package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Rating;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRatingDao implements TestDao {

    IDao<Rating> ratingIDao = Dao.getInstance(Rating.class);

    @Override
    @Test
    public void add() {
        assertTrue(ratingIDao.add(new Rating(ratingIDao.getNextId(), "a", 1L, "Muito Bom", 1)));
    }

    @Override
    @Test
    public void update() {
        Long id = ratingIDao.getNextId();

        Rating rating = new Rating(id, "a", 1L, "Muito Bom", 1);
        ratingIDao.add(rating);

        Rating rating2 = new Rating(id, "a", 1L, "Muito Ruim", 1);

        assertTrue(ratingIDao.update(id, rating2));
    }

    @Override
    @Test
    public void delete() {
        Long id = ratingIDao.getNextId();

        Rating rating = new Rating(id, "a", 1L, "Muito Bom", 1);
        ratingIDao.add(rating);

        assertTrue(ratingIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        Long id = ratingIDao.getNextId();
        Rating rating = new Rating(id, "a", 1L, "Muito Bom", 1);

        ratingIDao.add(rating);

        assertEquals(rating, ratingIDao.getById(id));
    }

    @Override
    @Test
    public void getAll() {
        var expected = ratingIDao.getAll().size() + 1;

        Rating rating = new Rating(ratingIDao.getNextId(), "a", 1L, "Muito Bom", 1);

        ratingIDao.add(rating);

        var actual = ratingIDao.getAll().size();

        assertEquals(expected, actual);
    }
}
