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

    @BeforeEach
    public void setUp() {
        Brand brand = new Brand(1L, "Dell");
        Department department = new Department(1L, "Hardware", "Hardware department");
        productDTO = new ProductDTO(1L, "Notebook Inspiron 15",
                4500, brand.getName(), "Notebook Intel Core i7 12a geração",
                department.getName(), 10);
    }

    @Test
    public void getIdReturnsCorrectId() {
        // Given
        Long expected = 1L;
        // When
        Long actual = productDTO.id();
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
        Brand brand = new Brand(1L, "Dell");
        Department department = new Department(1L, "Hardware", "Hardware department");
        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ProductDTO(1L, "Notebook Inspiron 15", 4500, brand.getName()
                , "Notebook Intel Core i7 12a geração", department.getName(), -1));

        assertEquals("Stock cannot be negative", exception.getMessage());
    }
}