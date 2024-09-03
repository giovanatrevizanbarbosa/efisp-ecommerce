package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRating {
    Rating rating;
    UUID id = UUID.randomUUID();
    UUID productId = UUID.randomUUID();

    @BeforeEach
    public void Initialize() {
        rating = new Rating(id, "caua@gmail.com", productId, "Excellent quality", 5);
    }

    @Test
    public void TestRatingGetOwnerEmail() {
        String expected = "caua@gmail.com";
        String actual = rating.getOwnerEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRatingGetProductId() {
        var expected = productId;
        var actual = rating.getProductId();

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