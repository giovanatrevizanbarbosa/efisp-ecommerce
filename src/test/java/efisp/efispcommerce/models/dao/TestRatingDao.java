package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Rating;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRatingDao implements TestDao {

    IDao<Rating> ratingIDao = new Dao<>(Rating.class);

    @Override
    @Test
    public void add() {
        Rating rating = new Rating(1L, "A@A.com", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a@a.com", 1L, "Muito Ruim", 1);

        assertTrue(ratingIDao.add(rating));
        assertTrue(ratingIDao.add(rating2));
        assertFalse(ratingIDao.add(rating));
    }

    @Override
    @Test
    public void update() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIDao.add(rating);
        ratingIDao.add(rating2);

        Rating rating3 = new Rating(3L, "a", 1L, "Muito Bom", 1);

        assertTrue(ratingIDao.update(1L, rating3));
    }

    @Override
    @Test
    public void delete() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIDao.add(rating);
        ratingIDao.add(rating2);

        assertTrue(ratingIDao.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIDao.add(rating);
        ratingIDao.add(rating2);

        var actual = ratingIDao.getById(2);

        assertEquals(rating2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIDao.add(rating);
        ratingIDao.add(rating2);

        var expected = 2;
        var actual = ratingIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(rating, ratingIDao.getAll().getFirst());
    }
}
