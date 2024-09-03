package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrandDao implements TestDao {

    IDao<Brand> brandIDao = Dao.getInstance(Brand.class);

    @Override
    @Test
    public void add() {
        Brand brand = new Brand(UUID.randomUUID(), "Samsung");
        assertTrue(brandIDao.add(brand));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();
        Brand brand = new Brand(id, "Samsung");

        brandIDao.add(brand);

        assertEquals(brand.getName(), brandIDao.getById(id).getName());
    }

    @Override
    @Test
    public void getAll() {

        var expected = brandIDao.getAll().size() + 1;

        Brand brand = new Brand(UUID.randomUUID(), "Samsung");

        brandIDao.add(brand);

        var actual = brandIDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();

        Brand brand = new Brand(id, "Samsung");
        brandIDao.add(brand);

        Brand brand3 = new Brand(id, "LG");

        assertTrue(brandIDao.update(id, brand3));
    }

    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();
        Brand brand = new Brand(id, "Amazon");

        brandIDao.add(brand);

        assertTrue(brandIDao.delete(id));
    }
}
