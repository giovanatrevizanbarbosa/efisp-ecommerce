package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.*;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCartDao implements TestDao {

    IDao<Cart> cartRepo = new Dao<>(Cart.class);


    @Test
    public void itemInCart(){
        IDao<Item> itemRepo = new Dao<>(Item.class);
        IDao<Brand> brandRepo = new Dao<>(Brand.class);
        IDao<Department> departmentRepo = new Dao<>(Department.class);
        IDao<Product> productRepo = new Dao<>(Product.class);
        IDao<Cart> cartRepo = new Dao<>(Cart.class);

        brandRepo.add(new Brand(1L, "Samsung"));
        departmentRepo.add(new Department(1L, "Informática", "Informática"));

        cartRepo.add(new Cart(1L, "a@a.com"));

        productRepo.add(new Product(1L, "Product 1", 1, brandRepo.getById(1L), null, departmentRepo.getById(1L), 1));
        productRepo.add(new Product(2L, "Product 2", 2, brandRepo.getById(1L), null, departmentRepo.getById(1L), 2));

        itemRepo.add(new Item(1L, 1L, productRepo.getById(1L), 1));
        itemRepo.add(new Item(2L, 1L, productRepo.getById(2L), 2));

        cartRepo.getById(1L).insertItem(itemRepo.getById(1L));
        cartRepo.getById(1L).insertItem(itemRepo.getById(2L));


        assertEquals(5, cartRepo.getById(1L).getTotalPrice());
    }

    @Override
    @Test
    public void add() {
        assertTrue(cartRepo.add(new Cart(1L, "a@a.com")));
        assertTrue(cartRepo.add(new Cart(2L, "b@b.com")));
    }

    @Override
    @Test
    public void update() {
        cartRepo.add(new Cart(1L, "a@a.com"));
        cartRepo.add(new Cart(2L, "b@b.com"));

        assertTrue(cartRepo.update(1L, new Cart(1L, "c@c.com")));
    }

    @Override
    @Test
    public void delete() {
        cartRepo.add(new Cart(1L, "a@a.com"));
        cartRepo.add(new Cart(2L, "b@b.com"));

        assertTrue(cartRepo.delete(2L));
    }

    @Override
    @Test
    public void getById() {
        cartRepo.add(new Cart(1L, "a@a.com"));
        cartRepo.add(new Cart(2L, "b@b.com"));

        assertEquals("a@a.com", cartRepo.getById(1L).getOwnerEmail());
    }

    @Override
    @Test
    public void getAll(){
        cartRepo.add(new Cart(1L, "a@a.com"));
        cartRepo.add(new Cart(2L, "b@b.com"));

        assertEquals(2, cartRepo.getAll().size());
    }

}
