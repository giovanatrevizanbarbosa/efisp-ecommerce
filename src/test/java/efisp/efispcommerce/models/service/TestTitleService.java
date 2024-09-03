package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.TitleDTO;
import efisp.efispecommerce.models.service.TitleService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTitleService {

    static TitleService titleService = new TitleService();

    @Test
    public void addTitle() {
        TitleDTO title = new TitleDTO(UUID.randomUUID(), "CEO", 1);
        assertTrue(titleService.add(title));
    }

    @Test
    public void updateTitle() {
        UUID id = UUID.randomUUID();

        TitleDTO title = new TitleDTO(id, "CEO", 1);

        assertTrue(titleService.add(title));
        assertTrue(titleService.update(id, title));
    }

    @Test
    public void deleteTitle() {
        UUID id = UUID.randomUUID();

        TitleDTO title = new TitleDTO(id, "CEO", 1);

        assertTrue(titleService.add(title));
        assertTrue(titleService.delete(id));
    }

    @Test
    public void getTitle() {
        UUID id = UUID.randomUUID();

        TitleDTO title = new TitleDTO(id, "CEO", 1);

        assertTrue(titleService.add(title));
        assertEquals(title, titleService.getTitleById(id));
    }

    @Test
    public void getAllTitles() {
        int expected = titleService.getAll().size() + 2;

        TitleDTO title = new TitleDTO(UUID.randomUUID(), "CEO", 1);
        TitleDTO title2 = new TitleDTO(UUID.randomUUID(), "CTO", 2);

        assertTrue(titleService.add(title));
        assertTrue(titleService.add(title2));

        assertEquals(expected, titleService.getAll().size());
    }

}
