package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestProductDTO {

    private ProductDTO productDTO;
    private UUID id;

    @BeforeEach
    public void setUp() {
        Brand brand = new Brand(UUID.randomUUID(), "Dell");
        Department department = new Department(UUID.randomUUID(), "Hardware", "Hardware department");
        id = UUID.randomUUID();
        productDTO = new ProductDTO(id, "Notebook Inspiron 15",
                4500, brand.getName(), "Notebook Intel Core i7 12a geração",
                department.getName(), 10, "image");
    }

    @Test
    public void getIdReturnsCorrectId() {
        // Given
        UUID expected = id;
        // When
        UUID actual = productDTO.id();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getNameReturnsCorrectName() {
        // Given
        String expected = "Notebook Inspiron 15";
        // When
        String actual = productDTO.name();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // Given
        double expected = 4500;
        // When
        double actual = productDTO.price();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getDescriptionReturnsCorrectDescription() {
        // Given
        String expected = "Notebook Intel Core i7 12a geração";
        // When
        String actual = productDTO.description();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getDepartmentReturnsCorrectDepartment() {
        // Given
        String expectedName = "Hardware";
        // When
        String actualName = productDTO.department();
        // Then
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getStockReturnsCorrectStock() {
        // Given
        int expected = 10;
        // When
        int actual = productDTO.stock();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void getBrandReturnsCorrectBrand() {
        // Given
        String expected = "Dell";
        // When
        String actual = productDTO.brand();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void constructorThrowsExceptionWhenStockIsNegative() {
        // Given
        Brand brand = new Brand(UUID.randomUUID(), "Dell");
        Department department = new Department(UUID.randomUUID(), "Hardware", "Hardware department");
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ProductDTO(UUID.randomUUID(), "Notebook Inspiron 15", 4500, brand.getName()
                , "Notebook Intel Core i7 12a geração", department.getName(), -1, "image"));

        assertEquals("Stock cannot be negative", exception.getMessage());
    }
}