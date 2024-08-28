package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Rating;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRating {
    Rating rating;

    public void Initialize() {
        rating = new Rating(1L, "caua@gmail.com", 1, "Excellent quality", 5);
    }

    @Test
    public void TestRatingGetOwnerEmail() {
        Initialize();

        String expected = "caua@gmail.com";
        String actual = rating.getOwnerEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetProductId() {
        Initialize();

        int expected = 1;
        int actual = rating.getProductId();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetComment() {
        Initialize();

        String expected = "Excellent quality";
        String actual = rating.getComment();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetRating() {
        Initialize();

        int expected = 5;
        int actual = rating.getRating();

        assertEquals(expected, actual);
    }
}