package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Title;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTitle {
    Title title;

    public void Initialize() {
        title = new Title("CEO", 10);
    }

    @Test
    public void TestTitleGetName() {
        Initialize();

        String expected = "CEO";
        String actual = title.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleGetPermissionLevel() {
        Initialize();

        int expected = 10;
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevel() {
        Initialize();

        int expected = 5;
        title.setPermissionLevel(5);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevelNotBelowOne() {
        Initialize();

        int expected = 10;
        title.setPermissionLevel(0);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }

    @Test
    public void TestTitleSetPermissionLevelNotAboveTen() {
        Initialize();

        int expected = 10;
        title.setPermissionLevel(11);
        int actual = title.getPermissionLevel();

        assertEquals(expected, actual);
    }
}