package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductDao implements TestDao {

    IDao<Product> productIDao = new Dao<>(Product.class);
    static IDao<Brand> brandIDao = new Dao<>(Brand.class);
    static IDao<Department> departmentIDao = new Dao<>(Department.class);

    @BeforeAll
    public static void setUp(){
        brandIDao.add(new Brand(1L, "Samsung"));
        brandIDao.add(new Brand(2L, "Apple"));

        departmentIDao.add(new Department(1L, "Informática", "Informática"));
        departmentIDao.add(new Department(2L, "Eletrônicos", "Eletrônicos"));
    }

    @Test
    public void testBrandAndDepartment(){
        productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1));
        productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2));

        assertEquals("Samsung", productIDao.getById(1L).getBrand().getName());
        assertEquals("Informática", productIDao.getById(1L).getDepartment().getName());

        assertEquals("Apple", productIDao.getById(2L).getBrand().getName());
        assertEquals("Eletrônicos", productIDao.getById(2L).getDepartment().getName());
    }

    @Override
    @Test
    public void add() {
        assertTrue(productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1)));
        assertTrue(productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2)));
    }

    @Override
    @Test
    public void update() {
        productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1));
        productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2));

        Product product3 = new Product(3L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2);

        assertTrue(productIDao.update(1L, product3));
    }

    @Override
    @Test
    public void delete() {
        productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1));
        productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2));

        assertTrue(productIDao.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1));
        productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2));

        var actual = productIDao.getById(2);

        assertEquals(2L, actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        productIDao.add(new Product(1L, "Samsung", 25.50, brandIDao.getById(1L), "Samsung Galaxy S20", departmentIDao.getById(1L), 1));
        productIDao.add(new Product(2L, "Apple", 50.00, brandIDao.getById(2L), "Iphone 12", departmentIDao.getById(2L), 2));

        var expected = 2;
        var actual = productIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(1L, productIDao.getAll().getFirst().getId());
    }

}
