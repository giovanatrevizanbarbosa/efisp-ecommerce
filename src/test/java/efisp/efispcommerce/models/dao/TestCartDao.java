package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCartDao implements TestDao {

    IDao<Cart> cartRepo = Dao.getInstance(Cart.class);


    @Test
    public void itemInCart(){
        IDao<Item> itemRepo = Dao.getInstance(Item.class);
        IDao<Brand> brandRepo = Dao.getInstance(Brand.class);
        IDao<Department> departmentRepo = Dao.getInstance(Department.class);
        IDao<Product> productRepo = Dao.getInstance(Product.class);
        IDao<Cart> cartRepo = Dao.getInstance(Cart.class);

        Long cartId = cartRepo.getNextId();

        Brand brand = new Brand(brandRepo.getNextId(), "Apple");
        Department department = new Department(departmentRepo.getNextId(), "Technology", "Varias coisas");
        Product product = new Product(productRepo.getNextId(), "Iphone", 1000.0, brand, "Smartphone", department, 10);
        Item item = new Item(itemRepo.getNextId(), cartId, product, 1);

        itemRepo.add(item);

        Cart cart = new Cart(cartRepo.getNextId(), "com");
        cart.insertItem(item);
        cartRepo.add(cart);


        assertTrue(cartRepo.getAll().getLast().getItems().containsValue(item));
    }

    @Override
    @Test
    public void add() {
        assertTrue(cartRepo.add(new Cart(cartRepo.getNextId(), "a@a.com")));
        assertTrue(cartRepo.add(new Cart(cartRepo.getNextId(), "b@b.com")));
    }

    @Override
    @Test
    public void update() {
        Long id = cartRepo.getNextId();
        cartRepo.add(new Cart(id, "a@a.com"));
        assertTrue(cartRepo.update(id, new Cart(id, "c@c.com")));
    }

    @Override
    @Test
    public void delete() {
        Long id = cartRepo.getNextId();

        cartRepo.add(new Cart(id, "b@b.com"));

        assertTrue(cartRepo.delete(id));
    }

    @Override
    @Test
    public void getById() {
        Long id = cartRepo.getNextId();
        cartRepo.add(new Cart(id, "a@a.com"));

        assertEquals("a@a.com", cartRepo.getById(id).getOwnerEmail());
    }

    @Override
    @Test
    public void getAll(){

        int size = cartRepo.getAll().size() + 2;

        cartRepo.add(new Cart(cartRepo.getNextId(), "a@a.com"));
        cartRepo.add(new Cart(cartRepo.getNextId(), "b@b.com"));

        assertEquals(size, cartRepo.getAll().size());
    }

}
