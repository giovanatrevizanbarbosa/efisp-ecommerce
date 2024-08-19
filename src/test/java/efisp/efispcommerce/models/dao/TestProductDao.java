package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.ProductDao;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestProductDao {

    @Test
    public void TestProductDaoAdd() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        boolean expected = true;
        boolean actual = productDao.add(product);

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductDaoGetById() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        productDao.add(product);

        Product actual = productDao.getById(0);

        assertEquals(product.getName(), actual.getName());
    }

    @Test
    public void TestProductDaoGetAll() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);
        Product product2 = new Product(2, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);


        productDao.add(product);
        productDao.add(product2);

        int expected = 2;
        int actual = productDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductDaoDelete() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"),5);

        productDao.add(product);

        productDao.delete(0);

        int expected = 0;
        int actual = productDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductDaoUpdate() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        productDao.add(product);

        Product product2 = new Product(1, "GeForce RTX 3080", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        productDao.update(1, product2);

        Product actual = productDao.getById(1);

        assertEquals(product2.getName(), actual.getName());
    }

    @Test
    public void TestProductDaoUpdateNotFound() {
        Dao<Product> productDao = ProductDao.getInstance();

        Product product = new Product(1, "GeForce GTX1660", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        productDao.add(product);

        Product product2 = new Product(2, "GeForce RTX 3080", 800, new Brand("Nvidia"), "GPU", new Department("Hardware", "Hardware department"), 5);

        boolean actual = productDao.update(2, product2);

        assertFalse(actual);
    }

}

