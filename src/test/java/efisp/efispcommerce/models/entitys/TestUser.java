package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    User user;
    UUID id;

    @BeforeEach
    public void Initialize() {
        id = UUID.randomUUID();
        user = new User(id, "Cauã", "caua@gmail.com", "Password123");
    }

    @Test
    public void TestUserGetId(){
        var expected = id;
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