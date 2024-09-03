package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCartDao implements TestDao {

    IDao<Cart> cartRepo = Dao.getInstance(Cart.class);

    @Test
    public void itemInCart(){
        IDao<Item> itemRepo = Dao.getInstance(Item.class);
        IDao<Product> productRepo = Dao.getInstance(Product.class);
        IDao<Brand> brandRepo = Dao.getInstance(Brand.class);
        IDao<Department> departmentRepo = Dao.getInstance(Department.class);

        var cartId = UUID.randomUUID();

        Brand brand = new Brand(UUID.randomUUID(), "Apple");
        brandRepo.add(brand);

        Department department = new Department(UUID.randomUUID(), "Technology", "Varias coisas");
        departmentRepo.add(department);

        Product product = new Product(UUID.randomUUID(), "Iphone", 1000.0, brand, "Smartphone", department, 10, "image");
        productRepo.add(product);

        Item item = new Item(UUID.randomUUID(), cartId, product, 1);
        itemRepo.add(item);

        Cart cart = new Cart(cartId, "com");
        cart.insertItem(item);
        cartRepo.add(cart);


        assertTrue(cartRepo.getById(cartId).getItems().containsKey(product.getId()));
    }

    @Override
    @Test
    public void add() {
        assertTrue(cartRepo.add(new Cart(UUID.randomUUID(), "a@a.com")));
        assertTrue(cartRepo.add(new Cart(UUID.randomUUID(), "b@b.com")));
    }

    @Override
    @Test
    public void update() {
        var id = UUID.randomUUID();
        cartRepo.add(new Cart(id, "a@a.com"));
        assertTrue(cartRepo.update(id, new Cart(id, "c@c.com")));
    }

    @Override
    @Test
    public void delete() {
        var id = UUID.randomUUID();

        cartRepo.add(new Cart(id, "b@b.com"));

        assertTrue(cartRepo.delete(id));
    }

    @Override
    @Test
    public void getById() {
        var id = UUID.randomUUID();
        cartRepo.add(new Cart(id, "a@a.com"));

        assertEquals("a@a.com", cartRepo.getById(id).getOwnerEmail());
    }

    @Override
    @Test
    public void getAll(){

        int size = cartRepo.getAll().size() + 2;

        cartRepo.add(new Cart(UUID.randomUUID(), "a@a.com"));
        cartRepo.add(new Cart(UUID.randomUUID(), "b@b.com"));

        assertEquals(size, cartRepo.getAll().size());
    }

}
