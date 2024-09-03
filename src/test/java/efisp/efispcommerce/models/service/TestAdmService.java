package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.models.service.AdmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdmService {

    static AdmService admService;

    @BeforeAll
    public static void setUp() {
        admService = new AdmService();}

    @Test
    public void addNewAdm() {
        assertTrue(admService.add(new AdmDTO(admService.getNextId(),"Igor", "igor@.com", "123", "CEO")));
    }


    @Test
    public void updateAdm() {
        Long id = admService.getNextId();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "kaun@gamil.com", "Password123", "CEO");
        assertTrue(admService.update(id, admDTO));
    }

    @Test
    public void deleteAdm() {

        assertTrue(admService.delete(1L));
    }

    @Test
    public void getAdmById() {
        Long id = admService.getNextId();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "CEO");
        admService.add(admDTO);

        assertEquals(admService.getById(id).id(), id);
    }

    @Test
    public void getAllAdms() {
        Long id = admService.getNextId();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "CEO");

        admService.add(admDTO);

        assertEquals(admService.getAll().getLast().id(), (long) id);
    }
}
