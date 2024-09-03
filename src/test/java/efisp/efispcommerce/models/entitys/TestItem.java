package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItem {
    Product product;
    Item item;

    @BeforeEach
    public void Initialize() {
        Brand brand = new Brand(UUID.randomUUID(), "Nvidia");
        Department department = new Department(UUID.randomUUID(), "Hardware", "Hardware department");
        product = new Product(UUID.randomUUID(), "GeForce GTX1660", 800, brand, "GPU", department, 10);

        item = new Item(UUID.randomUUID(), UUID.randomUUID(), product, 1);
    }

    @Test
    public void TestItemGetProduct() {
        Product expected = product;
        Product actual = item.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    public void TestItemGetQuantity() {
        int expected = 1;
        int actual = item.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    public void TestItemSetQuantity() {
        int expected = 2;
        item.setQuantity(2);
        int actual = item.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    public void TestItemSetQuantityNotBelowOne(){
        int expected = 1;
        item.setQuantity(0);
        assertEquals(expected, item.getQuantity());

        item.setQuantity(-1);
        assertEquals(expected, item.getQuantity());
    }
}