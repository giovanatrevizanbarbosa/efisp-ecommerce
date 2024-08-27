package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    User user;

    public void Initialize() {
        user = new User(1L, "Cauã", "caua@gmail.com", "Password123");
    }

    @Test
    public void TestUserGetId(){
        Initialize();

        var expected = 1;
        var actual = user.getId();

        assertEquals(expected,actual);
    }

    @Test
    public void TestUserGetName() {
        Initialize();

        String expected = "Cauã";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestUserGetEmail() {
        Initialize();

        String expected = "caua@gmail.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestUserGetPassword() {
        Initialize();

        String expected = "Password123";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }
}