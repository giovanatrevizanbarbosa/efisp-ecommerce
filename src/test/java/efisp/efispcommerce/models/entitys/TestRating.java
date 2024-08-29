package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRating {
    Rating rating;

    @BeforeEach
    public void Initialize() {
        rating = new Rating(1L, "caua@gmail.com", 1L, "Excellent quality", 5);
    }

    @Test
    public void TestRatingGetOwnerEmail() {
        String expected = "caua@gmail.com";
        String actual = rating.getOwnerEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetProductId() {
        long expected = 1;
        long actual = rating.getProductId();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetComment() {
        String expected = "Excellent quality";
        String actual = rating.getComment();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetRating() {
        int expected = 5;
        int actual = rating.getRating();

        assertEquals(expected, actual);
    }
}