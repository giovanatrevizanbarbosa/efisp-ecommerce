package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItemRepo implements TestRepo{

    IRepository<Item> itemRepo = new Repository<>(Item.class);
    static IRepository<Product> productRepo = new Repository<>(Product.class);
    static IRepository<Cart> cartRepo = new Repository<>(Cart.class);

    @BeforeAll
    public static void setUp() {
        IRepository<Brand> brandRepo = new Repository<>(Brand.class);
        brandRepo.add(new Brand(1L, "Samsung"));

        IRepository<Department> departmentRepo = new Repository<>(Department.class);
        departmentRepo.add(new Department(1L, "Informática", "Informática"));

        cartRepo.add(new Cart(1L, "a@a.com"));
        cartRepo.add(new Cart(2L, "b@b.com"));

        productRepo.add(new Product(1L, "Product 1", 1, brandRepo.getById(1L), null, departmentRepo.getById(1L), 1));
        productRepo.add(new Product(2L, "Product 2", 2, brandRepo.getById(1L), null, departmentRepo.getById(1L), 2));
    }

    @Override
    @Test
    public void add() {
        assertTrue(itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1)));
        assertTrue(itemRepo.add(new Item(2L, 2L, productRepo.getById(2L), 2)));
    }

    @Override
    @Test
    public void update() {
        itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1));
        itemRepo.add(new Item(2L, 2L, productRepo.getById(2L), 2));

        assertTrue(itemRepo.update(1L, new Item(1L, 1L, productRepo.getById(1L), 4)));
    }

    @Override
    @Test
    public void delete(){
        itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1));
        itemRepo.add(new Item(2L, 2L, productRepo.getById(2L), 2));

        assertTrue(itemRepo.delete(2L));
    }

    @Override
    @Test
    public void getById(){
        itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1));
        itemRepo.add(new Item(2L, 2L, productRepo.getById(2L), 3));

        assertEquals(3, itemRepo.getById(2L).getQuantity());
    }

    @Override
    @Test
    public void getAll(){
        itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1));
        itemRepo.add(new Item(2L, 2L, productRepo.getById(2L), 2));

        assertEquals(2, itemRepo.getAll().size());
    }

}