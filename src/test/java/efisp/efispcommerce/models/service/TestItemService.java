package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.*;
import efisp.efispecommerce.models.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItemService {

    static ItemService itemService = new ItemService();
    static ProductService productService = new ProductService();
    static BrandService brandService = new BrandService();
    static DepartmentService departmentService = new DepartmentService();
    static CartService cartService = new CartService();

    static ProductDTO product = new ProductDTO(UUID.randomUUID(), "Product 1", 20, "Brand 1", "Description 1", "Department 1", 10);
    static BrandDTO brand = new BrandDTO(UUID.randomUUID(), "Brand 1");
    static DepartmentDTO department = new DepartmentDTO(UUID.randomUUID(), "Department 1", "Description 1");
    static CartDTO cart = new CartDTO(UUID.randomUUID(), "User 1", new HashMap<>());


    @BeforeAll
    static void setUp(){
        brandService.add(brand);
        departmentService.add(department);
        productService.add(product);
        cartService.addCart(cart);
    }

    @Test
    public void addItem() {
        ItemDTO item = new ItemDTO(UUID.randomUUID(), product, cart.id(), 20);
        assertTrue(itemService.addItem(item));
    }

    @Test
    public void updateItem() {
        UUID id = UUID.randomUUID();

        ItemDTO item = new ItemDTO(id, product, cart.id(), 20);
        itemService.addItem(item);

        assertTrue(itemService.updateItem(id, item));
    }

    @Test
    public void deleteItem() {
        UUID id = UUID.randomUUID();

        ItemDTO item = new ItemDTO(id, product, cart.id(), 20);
        itemService.addItem(item);

        assertTrue(itemService.deleteItem(id));
    }

    @Test
    public void getItem() {
        UUID id = UUID.randomUUID();

        ItemDTO item = new ItemDTO(id, product, cart.id(), 20);
        itemService.addItem(item);

        assertEquals(itemService.getItemById(id).id(), id);
    }

    @Test
    public void getAllItems() {
        int expected = itemService.getAll().size() + 2;

        ItemDTO item = new ItemDTO(UUID.randomUUID(), product, cart.id(), 20);
        ItemDTO item2 = new ItemDTO(UUID.randomUUID(), product, cart.id(), 20);

        itemService.addItem(item);
        itemService.addItem(item2);

        int actual = itemService.getAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void getItemsByCartId(){
        int expected = itemService.getItemsByCartId(cart.id()).size() + 2;

        ItemDTO item = new ItemDTO(UUID.randomUUID(), product, cart.id(), 20);
        ItemDTO item2 = new ItemDTO(UUID.randomUUID(), product, cart.id(), 20);

        itemService.addItem(item);
        itemService.addItem(item2);

        int actual = itemService.getItemsByCartId(cart.id()).size();

        assertEquals(expected, actual);
    }

}
