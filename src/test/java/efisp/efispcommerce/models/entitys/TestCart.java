package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCart {
    Item itemA;
    Item itemB;
    Cart cart;
    UUID id;

    @BeforeEach
    public void Initialize(){
        id = UUID.randomUUID();
        cart = new Cart(id, "caua@gmail.com");

        Brand brandA = new Brand(UUID.randomUUID(), "Nvidia");
        Department departmentA = new Department(UUID.randomUUID(), "Hardware", "Hardware department");
        Product productA = new Product(UUID.randomUUID(), "GeForce GTX1660", 800, brandA, "GPU", departmentA, 10);
        itemA = new Item(UUID.randomUUID(), id, productA, 1);

        Brand brandB = new Brand(UUID.randomUUID(), "AMD");
        Department departmentB = new Department(UUID.randomUUID(), "Hardware", "Hardware department");
        Product productB = new Product(UUID.randomUUID(), " Ryzen 5 3600", 1200, brandB, "CPU", departmentB, 10);
        itemB = new Item(UUID.randomUUID(), id, productB, 1);

        cart.insertItem(itemA);
    }

    @Test
    public void TestCartGetId(){
        var expected = id;
        var actual = cart.getId();

        assertEquals(expected,actual);
    }

    @Test
    public void TestCartGetOwner() {
        String expected = "caua@gmail.com";
        String actual = cart.getOwnerEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartGetItems() {
        Map<UUID, Item> expected = new HashMap<>();
        expected.put(UUID.randomUUID(), itemA);
        Map<UUID, Item> actual = cart.getItems();

        assertNotEquals(expected, actual);
    }

    @Test
    public void TestCartGetItemsQuantityIncreaseAndDecrease() {
        var expected = 1;
        var actual = cart.getItemsQuantity();
        assertEquals(expected, actual);

        cart.insertItem(itemB);
        expected = 2;
        actual = cart.getItemsQuantity();
        assertEquals(expected, actual);

        cart.removeItem(itemA.getProduct().getId());
        expected = 1;
        actual = cart.getItemsQuantity();
        assertEquals(expected, actual);
    }

    @Test
    public void TestCartGetTotalPrice() {
        double expected = 800;
        double actual = cart.getTotalPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void TestCartInsertItem() {
        Map<UUID, Item> expected = new HashMap<>();
        expected.put(UUID.randomUUID(), itemA);
        expected.put(UUID.randomUUID(), itemB);

        cart.insertItem(itemB);
        Map<UUID, Item> actual = cart.getItems();

        assertEquals(expected.values().stream().sorted().toList(), actual.values().stream().sorted().toList());

        cart.insertItem(itemB);

        assertEquals(expected.values().stream().sorted().toList(), cart.getItems().values().stream().sorted().toList());
        assertEquals(2000, cart.getTotalPrice());
    }

    @Test
    public void TestCartRemoveItem() {
        Map<UUID, Item> expected = new HashMap<>();
        expected.put(UUID.randomUUID(), itemB);

        cart.insertItem(itemB);
        cart.removeItem(itemA.getProduct().getId());

        Map<UUID, Item> actual = cart.getItems();

        assertEquals(expected.values().stream().toList(), actual.values().stream().toList());
        assertEquals(1200, cart.getTotalPrice());
    }
}