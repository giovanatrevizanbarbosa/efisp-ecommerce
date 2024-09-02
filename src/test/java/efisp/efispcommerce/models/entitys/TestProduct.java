package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProduct {
    Brand brand;
    Department department;
    Product product;

    @BeforeEach
    public void Initialize() {
        brand = new Brand(1L, "Nvidia");
        department = new Department(1L, "Hardware", "Hardware department");
        product = new Product(1L, "GeForce GTX1660", 800, brand, "GPU", department, 10);
    }

    @Test
    public void TestProductGetId() {
        int expected = 1;
        int actual = Math.toIntExact(product.getId());

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductGetName() {
        String expected = "GeForce GTX1660";
        String actual = product.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductGetPrice() {
        double expected = 800;
        double actual = product.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductGetBrand() {
        Brand expected = brand;
        Brand actual = product.getBrand();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductGetDescription() {
        String expected = "GPU";
        String actual = product.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    public void TestProductGetDepartment() {
        Department expected = department;
        Department actual = product.getDepartment();

        assertEquals(expected, actual);
    }
}