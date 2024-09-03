package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.models.service.BrandService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrandService {

    private final BrandService service = new BrandService();

    @Test
    public void add() {
        var brand = new BrandDTO(service.getNextId(), "Google");
        var brand2 = new BrandDTO(service.getNextId(), "Microsoft");

        assertTrue(service.add(brand));
        assertTrue(service.add(brand2));
    }

    @Test
    public void getById() {
        Long id = service.getNextId();

        var brand = new BrandDTO(id, "Google");

        service.add(brand);

        assertEquals(brand, service.getById(id));
    }

    @Test
    public void getAll() {
        int expected = service.getAll().size() + 2;


        var brand = new BrandDTO(service.getNextId(), "Google");
        var brand2 = new BrandDTO(service.getNextId(), "Microsoft");

        service.add(brand);
        service.add(brand2);

        assertEquals(expected, service.getAll().size());
    }
}
