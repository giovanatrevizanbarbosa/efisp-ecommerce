package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductRepo implements TestRepo{

    IRepository<Product> productIRepository = new Repository<>(Product.class);
    static IRepository<Brand> brandIRepository = new Repository<>(Brand.class);
    static IRepository<Department> departmentIRepository = new Repository<>(Department.class);

    @BeforeAll
    public static void setUp(){
        brandIRepository.add(new Brand(1L, "Samsung"));
        brandIRepository.add(new Brand(2L, "Apple"));

        departmentIRepository.add(new Department(1L, "Informática", "Informática"));
        departmentIRepository.add(new Department(2L, "Eletrônicos", "Eletrônicos"));
    }

    @Override
    @Test
    public void add() {
        assertTrue(productIRepository.add(new Product(1L, "Samsung", 25.50, brandIRepository.getById(1L), "Samsung Galaxy S20", departmentIRepository.getById(1L), 1)));
        assertTrue(productIRepository.add(new Product(2L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2)));
    }

    @Override
    @Test
    public void update() {
        productIRepository.add(new Product(1L, "Samsung", 25.50, brandIRepository.getById(1L), "Samsung Galaxy S20", departmentIRepository.getById(1L), 1));
        productIRepository.add(new Product(2L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2));

        Product product3 = new Product(3L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2);

        assertTrue(productIRepository.update(1L, product3));
    }

    @Override
    @Test
    public void delete() {
        productIRepository.add(new Product(1L, "Samsung", 25.50, brandIRepository.getById(1L), "Samsung Galaxy S20", departmentIRepository.getById(1L), 1));
        productIRepository.add(new Product(2L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2));

        assertTrue(productIRepository.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        productIRepository.add(new Product(1L, "Samsung", 25.50, brandIRepository.getById(1L), "Samsung Galaxy S20", departmentIRepository.getById(1L), 1));
        productIRepository.add(new Product(2L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2));

        var actual = productIRepository.getById(2);

        assertEquals(2L, actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        productIRepository.add(new Product(1L, "Samsung", 25.50, brandIRepository.getById(1L), "Samsung Galaxy S20", departmentIRepository.getById(1L), 1));
        productIRepository.add(new Product(2L, "Apple", 50.00, brandIRepository.getById(2L), "Iphone 12", departmentIRepository.getById(2L), 2));

        var expected = 2;
        var actual = productIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(1L, productIRepository.getAll().getFirst().getId());
    }

}
