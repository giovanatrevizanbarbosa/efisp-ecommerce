package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCart {
    Item itemA;
    Item itemB;
    Cart cart;

    public void Initialize(){
        cart = new Cart(1, "caua@gmail.com");

        Brand brandA = new Brand("Nvidia");
        Department departmentA = new Department("Hardware", "Hardware department");
        Product productA = new Product(1, "GeForce GTX1660", 800, brandA, "GPU", departmentA, 10);
        itemA = new Item(productA, 1);

        Brand brandB = new Brand("Intel");
        Department departmentB = new Department("Hardware", "Hardware department");
        Product productB = new Product(2, "i5 11300H", 1200, brandB, "CPU", departmentB, 10);

        itemB = new Item(productB, 1);

        cart.insertItem(itemA);
    }

    @Test
    public void TestCartGetId(){
        Initialize();

        var expected = 1;
        var actual = cart.getId();

        assertEquals(expected,actual);
    }

    @Test
    public void TestCartGetOwner() {
        Initialize();

        String expected = "caua@gmail.com";
        String actual = cart.getOwnerEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartGetItems() {
        Initialize();

        Map<Integer, Item> expected = new HashMap<>();
        expected.put(1, itemA);
        Map<Integer, Item> actual = cart.getItems();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartGetTotalPrice() {
        Initialize();

        double expected = 800;
        double actual = cart.getTotalPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartInsertItem() {
        Initialize();

        Map<Integer, Item> expected = new HashMap<>();
        expected.put(1, itemA);
        expected.put(2, itemB);

        cart.insertItem(itemB);
        Map<Integer, Item> actual = cart.getItems();

        assertEquals(expected, actual);

        cart.insertItem(itemB);

        assertEquals(expected, cart.getItems());
        assertEquals(2000, cart.getTotalPrice());
    }

    @Test
    public void TestCartRemoveItem() {
        Initialize();

        Map<Integer, Item> expected = new HashMap<>();
        expected.put(2, itemB);

        cart.insertItem(itemB);
        cart.removeItem(itemA.getProduct().getId().intValue());

        Map<Integer, Item> actual = cart.getItems();

        assertEquals(expected, actual);
        assertEquals(1200, cart.getTotalPrice());
    }
}