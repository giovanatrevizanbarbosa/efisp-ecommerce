package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Rating;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRatingRepo implements TestRepo{

    IRepository<Rating> ratingIRepository = new Repository<>(Rating.class);

    @Override
    @Test
    public void add() {
        Rating rating = new Rating(1L, "A@A.com", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a@a.com", 1L, "Muito Ruim", 1);

        assertTrue(ratingIRepository.add(rating));
        assertTrue(ratingIRepository.add(rating2));
        assertFalse(ratingIRepository.add(rating));
    }

    @Override
    @Test
    public void update() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIRepository.add(rating);
        ratingIRepository.add(rating2);

        Rating rating3 = new Rating(3L, "a", 1L, "Muito Bom", 1);

        assertTrue(ratingIRepository.update(1L, rating3));
    }

    @Override
    @Test
    public void delete() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIRepository.add(rating);
        ratingIRepository.add(rating2);

        assertTrue(ratingIRepository.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIRepository.add(rating);
        ratingIRepository.add(rating2);

        var actual = ratingIRepository.getById(2);

        assertEquals(rating2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Rating rating = new Rating(1L, "a", 1L, "Muito Bom", 1);
        Rating rating2 = new Rating(2L, "a", 1L, "Muito Ruim", 1);

        ratingIRepository.add(rating);
        ratingIRepository.add(rating2);

        var expected = 2;
        var actual = ratingIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(rating, ratingIRepository.getAll().getFirst());
    }
}
