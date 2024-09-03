package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDepartmentDao implements TestDao {

    IDao<Department> departamentIDao = Dao.getInstance(Department.class);

    @Override
    @Test
    public void add() {
        Department department = new Department(departamentIDao.getNextId(), "Informática", "Informática");
        Department department2 = new Department(departamentIDao.getNextId(), "Eletrônicos", "Eletrônicos");

        assertTrue(departamentIDao.add(department));
        assertTrue(departamentIDao.add(department2));
    }

    @Override
    @Test
    public void getById() {
        Long id = departamentIDao.getNextId();
        Department department = new Department(id, "Informática", "Informática");
        departamentIDao.add(department);


        var actual = departamentIDao.getById(id);
        assertEquals(department, actual);
    }

    @Override
    @Test
    public void getAll() {
        Department department = new Department(departamentIDao.getNextId(), "Informática", "Informática");
        Department department2 = new Department(departamentIDao.getNextId(), "Eletrônicos", "Eletrônicos");

        var expected = departamentIDao.getAll().size() + 2;

        departamentIDao.add(department);
        departamentIDao.add(department2);


        var actual = departamentIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(department2, departamentIDao.getAll().getLast());
    }

    @Override
    @Test
    public void update() {
        Long id = departamentIDao.getNextId();
        Department department = new Department(id, "Informática", "Informática");
        departamentIDao.add(department);

        Department department3 = new Department(departamentIDao.getNextId(), "Informática", "Informática");

        assertTrue(departamentIDao.update(id, department3));
    }

    @Override
    @Test
    public void delete() {
        Long id = departamentIDao.getNextId();
        Department department = new Department(id, "Informática", "Informática");
        departamentIDao.add(department);

        assertTrue(departamentIDao.delete(id));
    }
}
