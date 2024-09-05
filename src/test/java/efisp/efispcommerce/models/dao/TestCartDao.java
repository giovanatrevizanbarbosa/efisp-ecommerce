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

        Product product = new Product(UUID.randomUUID(), "Iphone", 1000.0, brand, "Smartphone", department, 10, "photo");
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

        Dao.getInstance(User.class).add(new User(UUID.randomUUID(), "igor", "daoCartTest@2gamilc.om", "123456"));
        Dao.getInstance(User.class).add(new User(UUID.randomUUID(), "igor", "daoCartTest@1gamilc.om", "123456"));

        assertTrue(cartRepo.add(new Cart(UUID.randomUUID(), "daoCartTest@2gamilc.om")));
        assertTrue(cartRepo.add(new Cart(UUID.randomUUID(), "daoCartTest@1gamilc.om")));
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

        Dao.getInstance(User.class).add(new User(UUID.randomUUID(), "igor", "fasbnahbfashbf@gmai.com", "123456"));

        assertTrue(cartRepo.add(new Cart(id, "fasbnahbfashbf@gmai.com")));
        assertEquals("fasbnahbfashbf@gmai.com", cartRepo.getById(id).getOwnerEmail());
    }

    @Override
    @Test
    public void getAll(){

        Dao.getInstance(User.class).add(new User(UUID.randomUUID(), "igor", "fasbnahbffashbf@gmai.com", "123456"));
        Dao.getInstance(User.class).add(new User(UUID.randomUUID(), "igor", "fasbnahbfadshbf@gmai.com", "123456"));


        int size = cartRepo.getAll().size() + 2;

        cartRepo.add(new Cart(UUID.randomUUID(), "fasbnahbffashbf@gmai.com"));
        cartRepo.add(new Cart(UUID.randomUUID(), "fasbnahbfadshbf@gmai.com"));

        assertEquals(size, cartRepo.getAll().size());
    }

}
