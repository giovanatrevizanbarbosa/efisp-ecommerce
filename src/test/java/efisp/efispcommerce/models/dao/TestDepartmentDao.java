package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepartmentDao implements TestDao {

    IDao<Department> departamentIDao = new Dao<>(Department.class);

    @Override
    @Test
    public void add() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        assertTrue(departamentIDao.add(department));
        assertTrue(departamentIDao.add(department2));
        assertEquals(departamentIDao.getAll().getFirst().getId(), department.getId());
    }

    @Override
    @Test
    public void getById() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIDao.add(department);
        departamentIDao.add(department2);

        var actual = departamentIDao.getById(2);
        assertEquals(department2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIDao.add(department);
        departamentIDao.add(department2);

        var expected = 2;
        var actual = departamentIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(department, departamentIDao.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIDao.add(department);
        departamentIDao.add(department2);

        Department department3 = new Department(3L, "Informática", "Informática");

        assertTrue(departamentIDao.update(1L, department3));
    }

    @Override
    @Test
    public void delete() {
        Department department = new Department(1L, "Informática", "Informática");
        Department department2 = new Department(2L, "Eletrônicos", "Eletrônicos");

        departamentIDao.add(department);
        departamentIDao.add(department2);

        assertTrue(departamentIDao.delete(1L));
    }
}
