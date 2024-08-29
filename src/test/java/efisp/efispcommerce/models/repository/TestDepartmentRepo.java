package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepartmentRepo implements TestRepo{

    IRepository<Department> departamentIRepository = new Repository<>(Department.class);

    @Override
    @Test
    public void add() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        assertTrue(departamentIRepository.add(department));
        assertTrue(departamentIRepository.add(department2));
        assertEquals(departamentIRepository.getAll().getFirst().getId(), department.getId());
    }

    @Override
    @Test
    public void getById() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIRepository.add(department);
        departamentIRepository.add(department2);

        var actual = departamentIRepository.getById(2);
        assertEquals(department2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIRepository.add(department);
        departamentIRepository.add(department2);

        var expected = 2;
        var actual = departamentIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(department, departamentIRepository.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIRepository.add(department);
        departamentIRepository.add(department2);

        Department department3 = new Department(3L, "Informática", "Informática");

        assertTrue(departamentIRepository.update(1L, department3));
    }

    @Override
    @Test
    public void delete() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIRepository.add(department);
        departamentIRepository.add(department2);

        assertTrue(departamentIRepository.delete(1L));
    }
}
