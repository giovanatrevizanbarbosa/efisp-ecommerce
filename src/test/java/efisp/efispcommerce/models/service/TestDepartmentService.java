package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.DepartmentDTO;
import efisp.efispecommerce.models.service.DepartmentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepartmentService {

    private final DepartmentService service = new DepartmentService();

    @Test
    public void add() {
        var department = new DepartmentDTO(service.getNextId(), "Informática", "Informática");
        var department2 = new DepartmentDTO(service.getNextId(), "Eletrônicos", "Eletrônicos");

        assertTrue(service.add(department));
        assertTrue(service.add(department2));
    }

    @Test
    public void getById() {
        Long id = service.getNextId();
        var department = new DepartmentDTO(id, "Informática", "Informática");
        service.add(department);

        var actual = service.getById(id);
        assertEquals(department, actual);
    }

    @Test
    public void getAll() {
        var department = new DepartmentDTO(service.getNextId(), "Informática", "Informática");
        var department2 = new DepartmentDTO(service.getNextId(), "Eletrônicos", "Eletrônicos");

        var expected = service.getAll().size() + 2;

        service.add(department);
        service.add(department2);

        var actual = service.getAll().size();

        assertEquals(expected, actual);
        assertEquals(department, service.getAll().getFirst());
    }
}
