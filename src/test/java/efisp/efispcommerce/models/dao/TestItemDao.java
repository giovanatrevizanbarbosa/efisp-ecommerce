package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItemDao implements TestDao {

    IDao<Item> itemRepo = Dao.getInstance(Item.class);
    static IDao<Product> productRepo = Dao.getInstance(Product.class);
    static IDao<Cart> cartRepo = Dao.getInstance(Cart.class);

    static UUID productId = UUID.randomUUID();
    static UUID cartId = UUID.randomUUID();

    @BeforeAll
    public static void setUp() {
        IDao<Brand> brandRepo = Dao.getInstance(Brand.class);
        var brandId = UUID.randomUUID();
        brandRepo.add(new Brand(brandId, "Samsung"));

        IDao<Department> departmentRepo = Dao.getInstance(Department.class);
        var departmentId = UUID.randomUUID();
        departmentRepo.add(new Department(departmentId, "Informática", "Informática"));

        cartRepo.add(new Cart(cartId, "a@a.com"));

        assertTrue(productRepo.add(new Product(productId, "Product 1", 1, brandRepo.getById(brandId), "Mui Bom", departmentRepo.getById(departmentId), 1, "photo")));
    }

    @Override
    @Test
    public void add() {
        assertTrue(itemRepo.add(new Item(UUID.randomUUID(), cartId, productRepo.getById(productId), 1)));
    }

    @Override
    @Test
    public void update() {
        UUID id = UUID.randomUUID();
        itemRepo.add(new Item(id, cartId, productRepo.getById(productId), 1));

        assertTrue(itemRepo.update(id, new Item(id, cartId, productRepo.getById(productId), 2)));
    }

    @Override
    @Test
    public void delete(){
        UUID id = UUID.randomUUID();
        itemRepo.add(new Item(id, cartId, productRepo.getById(productId), 1));

        assertTrue(itemRepo.delete(id));
    }

    @Override
    @Test
    public void getById(){
        UUID id = UUID.randomUUID();
        var expected = new Item(id, cartId, productRepo.getById(productId), 1);

        itemRepo.add(expected);

        var actual = itemRepo.getById(id);

        assertEquals(expected, actual);
    }

    @Override
    @Test
    public void getAll(){
        var expected = itemRepo.getAll().size() + 1;
        itemRepo.add(new Item(UUID.randomUUID(), cartId, productRepo.getById(productId), 1));

        var actual = itemRepo.getAll().size();

        assertEquals(expected, actual);
    }

}
