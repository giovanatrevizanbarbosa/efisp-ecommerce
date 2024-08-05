package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    User user;

    public void Initialize() {
        user = new User("Cauã", "caua@gmail.com", "Password123");
    }

    @Test
    public void getName() {
        Initialize();

        String expected = "Cauã";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getEmail() {
        Initialize();

        String expected = "caua@gmail.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void getPassword() {
        Initialize();

        String expected = "Password123";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }
}