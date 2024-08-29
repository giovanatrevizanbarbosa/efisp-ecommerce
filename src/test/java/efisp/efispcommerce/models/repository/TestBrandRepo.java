package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBrandRepo implements TestRepo {

    IRepository<Brand> brandIRepository = new Repository<>(Brand.class);

    @Override
    @Test
    public void add() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        assertTrue(brandIRepository.add(brand));
        assertTrue(brandIRepository.add(brand2));
        assertEquals(brandIRepository.getAll().getFirst().getId(), brand.getId());
    }

    @Override
    @Test
    public void getById() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIRepository.add(brand);
        brandIRepository.add(brand2);

        var actual = brandIRepository.getById(2);
        assertEquals(brand2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIRepository.add(brand);
        brandIRepository.add(brand2);

        var expected = 2;
        var actual = brandIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(brand, brandIRepository.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIRepository.add(brand);
        brandIRepository.add(brand2);

        Brand brand3 = new Brand(3L, "Samsung");

        assertTrue(brandIRepository.update(1L, brand3));
    }

    @Override
    @Test
    public void delete() {
        Brand brand = new Brand(1L, "Samsung");
        Brand brand2 = new Brand(2L, "Apple");

        brandIRepository.add(brand);
        brandIRepository.add(brand2);

        assertTrue(brandIRepository.delete(1L));
    }
}
