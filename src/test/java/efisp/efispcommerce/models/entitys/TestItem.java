package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.entitys.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItem {
    Product product;
    Item item;

    public void Initialize() {
        Brand brand = new Brand(1L, "Nvidia");
        Department department = new Department(1L, "Hardware", "Hardware department");
        product = new Product(1L, "GeForce GTX1660", 800, brand, "GPU", department, 10);
        item = new Item(1L, 1L, product, 1);
    }

    @Test
    public void TestItemGetProduct() {
        Initialize();

        Product expected = product;
        Product actual = item.getProduct();

        assertEquals(expected, actual);
    }

    @Test
    public void TestItemGetQuantity() {
        Initialize();

        int expected = 1;
        int actual = item.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    public void TestItemSetQuantity() {
        Initialize();

        int expected = 2;
        item.setQuantity(2);

        assertEquals(expected, 2);
    }

    @Test
    public void TestItemSetQuantityNotBelowOne(){
        Initialize();

        int expected = 1;
        item.setQuantity(0);
        assertEquals(expected, item.getQuantity());

        item.setQuantity(-1);
        assertEquals(expected, item.getQuantity());
    }
}