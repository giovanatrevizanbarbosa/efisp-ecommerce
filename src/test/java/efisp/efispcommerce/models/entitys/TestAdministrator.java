package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministrator {
    Title admTitle;
    Administrator administrator;

    public void Initialize(){
        admTitle = new Title("CEO", 10);
        administrator = new Administrator("Cauã", "caua@gmail.com", "Password123", admTitle);
    }

    @Test
    public void TestAdministratorGetTitle() {
        Initialize();

        Title actual = administrator.getTitle();

        assertEquals(admTitle, actual);
    }

    @Test
    public void TestAdministratorSetTitle() {
        Initialize();

        Title expected = new Title("Employee", 5);
        administrator.setTitle(expected);
        Title actual = administrator.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAdministratorSetTitleNotNull() {
        Initialize();

        administrator.setTitle(null);
        Title actual = administrator.getTitle();

        assertNotNull(actual);
    }
}