package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministrator {
    Title admTitle;
    Administrator administrator;
    UUID id;

    @BeforeEach
    public void Initialize(){
        admTitle = new Title(UUID.randomUUID(),"CEO", 10);
        id = UUID.randomUUID();
        administrator = new Administrator(id, "Cauã", "caua@gmail.com", "Password123", admTitle);
    }

    @Test
    public void TestAdministratorGetId(){
        var expected = id;
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
        Title expected = new Title(UUID.randomUUID(),"Employee", 5);
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