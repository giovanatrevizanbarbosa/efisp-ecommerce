package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestProductDTO {

    private ProductDTO productDTO;
    private Brand brand;
    private Department department;

    @BeforeEach
    public void setUp() {
        brand = new Brand("Dell");
        department = new Department("Hardware", "Hardware department");
        productDTO = new ProductDTO(1, "Notebook Inspiron 15",
                4500, brand, "Notebook Intel Core i7 12a geração",
                department, 10);
    }

    @Test
    public void getIdReturnsCorrectId() {
        // Given
        int expected = 1;
        // When
        int actual = productDTO.getId();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getNameReturnsCorrectName() {
        // Given
        String expected = "Notebook Inspiron 15";
        // When
        String actual = productDTO.getName();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // Given
        double expected = 4500;
        // When
        double actual = productDTO.getPrice();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getDescriptionReturnsCorrectDescription() {
        // Given
        String expected = "Notebook Intel Core i7 12a geração";
        // When
        String actual = productDTO.getDescription();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getDepartmentReturnsCorrectDepartment() {
        // Given
        String expectedName = "Hardware";
        String expectedDescription = "Hardware department";
        // When
        String actualName = productDTO.getDepartment().getName();
        String actualDescription = productDTO.getDepartment().getDescription();
        // Then
        assertEquals(expectedName, actualName);
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void getStockReturnsCorrectStock() {
        // Given
        int expected = 10;
        // When
        int actual = productDTO.getStock();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getBrandReturnsCorrectBrand() {
        // Given
        String expected = "Dell";
        // When
        String actual = productDTO.getBrand().getName();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void constructorThrowsExceptionWhenStockIsNegative() {
        // Given
        Brand brand = new Brand("Dell");
        Department department = new Department("Hardware", "Hardware department");
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ProductDTO(1, "Notebook Inspiron 15", 4500, brand
                    , "Notebook Intel Core i7 12a geração", department, -1);
        });

        assertEquals("Stock cannot be negative", exception.getMessage());
    }
}