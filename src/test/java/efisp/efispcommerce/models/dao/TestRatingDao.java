package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Rating;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestRatingDao implements TestDao {

    IDao<Rating> ratingIDao = Dao.getInstance(Rating.class);
    UUID productId = UUID.randomUUID();

    @Override
    @Test
    public void add() {
        assertTrue(ratingIDao.add(new Rating(UUID.randomUUID(), "a", productId, "Muito Bom", 1)));
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();

        Rating rating = new Rating(id, "a", productId, "Muito Bom", 1);
        ratingIDao.add(rating);

        Rating rating2 = new Rating(id, "a", productId, "Muito Ruim", 1);

        assertTrue(ratingIDao.update(id, rating2));
    }

    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();

        Rating rating = new Rating(id, "a", productId, "Muito Bom", 1);
        ratingIDao.add(rating);

        assertTrue(ratingIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();
        Rating rating = new Rating(id, "a", productId, "Muito Bom", 1);

        ratingIDao.add(rating);

        assertEquals(rating, ratingIDao.getById(id));
    }

    @Override
    @Test
    public void getAll() {
        var expected = ratingIDao.getAll().size() + 1;

        Rating rating = new Rating(UUID.randomUUID(), "a", productId, "Muito Bom", 1);

        ratingIDao.add(rating);

        var actual = ratingIDao.getAll().size();

        assertEquals(expected, actual);
    }
}
