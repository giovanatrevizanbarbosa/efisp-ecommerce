package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrandDao implements TestDao {

    IDao<Brand> brandIDao = new Dao<>(Brand.class);

    @Override
    @Test
    public void add() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        assertTrue(brandIDao.add(brand));
        assertTrue(brandIDao.add(brand2));
        assertEquals(brandIDao.getAll().getFirst().getId(), brand.getId());
    }

    @Override
    @Test
    public void getById() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIDao.add(brand);
        brandIDao.add(brand2);

        var actual = brandIDao.getById(2);
        assertEquals(brand2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIDao.add(brand);
        brandIDao.add(brand2);

        var expected = 2;
        var actual = brandIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(brand, brandIDao.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIDao.add(brand);
        brandIDao.add(brand2);

        Brand brand3 = new Brand(3L, "Samsung");

        assertTrue(brandIDao.update(1L, brand3));
    }

    @Override
    @Test
    public void delete() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIDao.add(brand);
        brandIDao.add(brand2);

        assertTrue(brandIDao.delete(1L));
    }
}
