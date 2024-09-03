package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.service.AdmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdmService {

    static AdmService admService;

    @BeforeAll
    public static void setUp() {
        admService = new AdmService();}

    @Test
    public void addNewAdm() {
        assertTrue(admService.add(new AdmDTO(UUID.randomUUID(),"Igor", "igor@.com", "123", "CEO")));
    }


    @Test
    public void updateAdm() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "kaun@gamil.com", "Password123", "CEO");
        assertTrue(admService.update(id, admDTO));
    }

    @Test
    public void deleteAdm() {

        var id = UUID.randomUUID();

        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "CEO");

        admService.add(admDTO);

        assertTrue(admService.delete(id));
    }

    @Test
    public void getAdmById() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "CEO");
        admService.add(admDTO);

        assertEquals(admService.getById(id).id(), id);
    }

    @Test
    public void getAllAdms() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "CEO");

        admService.add(admDTO);

        assertEquals(admService.getById(id).id(), id);
    }
}
