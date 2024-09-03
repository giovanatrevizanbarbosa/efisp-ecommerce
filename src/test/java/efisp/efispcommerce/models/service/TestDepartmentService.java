package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.models.service.DepartmentService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepartmentService {

    private final DepartmentService service = new DepartmentService();

    @Test
    public void add() {
        var department = new DepartmentDTO(UUID.randomUUID(), "Informática", "Informática");
        var department2 = new DepartmentDTO(UUID.randomUUID(), "Eletrônicos", "Eletrônicos");

        assertTrue(service.add(department));
        assertTrue(service.add(department2));
    }

    @Test
    public void getById() {
        var id = UUID.randomUUID();
        var department = new DepartmentDTO(id, "Informática", "Informática");
        service.add(department);

        var actual = service.getById(id);
        assertEquals(department, actual);
    }

    @Test
    public void getAll() {
        var department = new DepartmentDTO(UUID.randomUUID(), "Informática", "Informática");
        var department2 = new DepartmentDTO(UUID.randomUUID(), "Eletrônicos", "Eletrônicos");

        var expected = service.getAll().size() + 2;

        service.add(department);
        service.add(department2);

        var actual = service.getAll().size();

        assertEquals(expected, actual);
        assertEquals(department, service.getById(department.id()));
    }
}
