package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.AdmDTO;
import efisp.efispecommerce.dto.TitleDTO;
import efisp.efispecommerce.models.service.AdmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdmService {

    static AdmService admService;
    static TitleDTO titleDTO;
    static UUID titleId = UUID.randomUUID();

    @BeforeAll
    public static void setUp() {
        titleDTO = new TitleDTO(titleId, "CEO", 1);
        admService = new AdmService();}

    @Test
    public void addNewAdm() {
        assertTrue(admService.add(new AdmDTO(UUID.randomUUID(),"Igor", "igor@.com", "123", "photo", titleDTO)));
    }


    @Test
    public void updateAdm() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "kaun@gamil.com", "Password123", "photo", titleDTO);
        assertTrue(admService.update(id, admDTO));
    }

    @Test
    public void deleteAdm() {

        var id = UUID.randomUUID();

        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "photo", titleDTO);

        admService.add(admDTO);

        assertTrue(admService.delete(id));
    }

    @Test
    public void getAdmById() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "photo", titleDTO);
        admService.add(admDTO);

        assertEquals(admService.getById(id).id(), id);
    }

    @Test
    public void getAllAdms() {
        var id = UUID.randomUUID();
        AdmDTO admDTO = new AdmDTO(id, "Cauã", "a.com", "123", "photo", titleDTO);

        admService.add(admDTO);

        assertEquals(admService.getById(id).id(), id);
    }
}
