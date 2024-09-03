package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTitle {
    Title title;

    @BeforeEach
    public void Initialize() {
        title = new Title(UUID.randomUUID(), "CEO", 10);
    }

    @Test
    public void TestTitleGetName() {
        String expected = "CEO";
        String actual = title.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleGetPermissionLevel() {
        int expected = 10;
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevel() {
        int expected = 5;
        title.setPermissionLevel(5);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevelNotBelowOne() {
        int expected = 10;
        title.setPermissionLevel(0);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevelNotAboveTen() {
        int expected = 10;
        title.setPermissionLevel(11);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }
}