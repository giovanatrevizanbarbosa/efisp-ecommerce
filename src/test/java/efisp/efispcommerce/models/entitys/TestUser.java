package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    User user;

    @BeforeEach
    public void Initialize() {
        user = new User(1L, "Cauã", "caua@gmail.com", "Password123");
    }

    @Test
    public void TestUserGetId(){
        var expected = 1;
        var actual = user.getId();

        assertEquals(expected,actual);
    }

    @Test
    public void TestUserGetName() {
        String expected = "Cauã";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestUserGetEmail() {
        String expected = "caua@gmail.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestUserGetPassword() {
        String expected = "Password123";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }
}