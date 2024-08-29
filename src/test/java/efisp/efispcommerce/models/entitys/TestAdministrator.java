package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministrator {
    Title admTitle;
    Administrator administrator;

    @BeforeEach
    public void Initialize(){
        admTitle = new Title(1L,"CEO", 10);
        administrator = new Administrator(1L, "Cauã", "caua@gmail.com", "Password123", admTitle);
    }

    @Test
    public void TestAdministratorGetId(){
        var expected = 1;
        var actual = administrator.getId();

        assertEquals(expected,actual);
    }

    @Test
    public void TestAdministratorGetTitle() {
        Title actual = administrator.getTitle();

        assertEquals(admTitle, actual);
    }

    @Test
    public void TestAdministratorSetTitle() {
        Title expected = new Title(1L,"Employee", 5);
        administrator.setTitle(expected);
        Title actual = administrator.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAdministratorSetTitleNotNull() {
        administrator.setTitle(null);
        Title actual = administrator.getTitle();

        assertNotNull(actual);
    }
}