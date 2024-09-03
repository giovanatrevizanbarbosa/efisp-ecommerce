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

    IDao<Product> productIDao = Dao.getInstance(Product.class);
    static IDao<Brand> brandIDao = Dao.getInstance(Brand.class);
    static IDao<Department> departmentIDao = Dao.getInstance(Department.class);

    static Long brandId = brandIDao.getNextId();
    static Long departmentId = departmentIDao.getNextId();

    @BeforeAll
    public static void setUp(){
        brandIDao.add(new Brand(brandId, "Samsung"));
        departmentIDao.add(new Department(departmentId, "Eletrônicos", "Eletrônicos"));
    }

    @Test
    public void testBrandAndDepartment(){
        var brand = brandIDao.getById(brandId);
        var department = departmentIDao.getById(departmentId);

        assertEquals("Samsung", brand.getName());
        assertEquals("Eletrônicos", department.getName());
    }

    @Override
    @Test
    public void add() {
        assertTrue(productIDao.add(new Product(productIDao.getNextId(), "Samsung", 25.50, brandIDao.getById(brandId), "Samsung Galaxy S20", departmentIDao.getById(departmentId), 1)));
    }

    @Override
    @Test
    public void update() {
        Long id = productIDao.getNextId();

        productIDao.add(new Product(id, "Samsung", 25.50, brandIDao.getById(brandId), "Samsung Galaxy S20", departmentIDao.getById(departmentId), 1));

        Product product3 = new Product(id, "Apple", 50.00, brandIDao.getById(brandId), "Iphone 12", departmentIDao.getById(departmentId), 5);

        assertTrue(productIDao.update(id, product3));
    }

    @Override
    @Test
    public void delete() {
        Long id = productIDao.getNextId();

        productIDao.add(new Product(id, "Samsung", 25.50, brandIDao.getById(brandId), "Samsung Galaxy S20", departmentIDao.getById(departmentId), 1));

        assertTrue(productIDao.delete(id));
    }

    @Override
    @Test
    public void getById() {
        Long id = productIDao.getNextId();
        Product product = new Product(id, "Samsung", 25.50, brandIDao.getById(brandId), "Samsung Galaxy S20", departmentIDao.getById(departmentId), 1);

        productIDao.add(product);

        assertEquals(product, productIDao.getById(id));
    }

    @Override
    @Test
    public void getAll() {
        var expected = productIDao.getAll().size() + 1;

        Product product = new Product(productIDao.getNextId(), "Samsung", 25.50, brandIDao.getById(brandId), "Samsung Galaxy S20", departmentIDao.getById(departmentId), 1);

        productIDao.add(product);

        var actual = productIDao.getAll().size();

        assertEquals(expected, actual);
    }

}
