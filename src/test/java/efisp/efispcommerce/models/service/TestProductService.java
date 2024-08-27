package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProductService {
    private ProductDTO productDTO;
    private ProductService productService;
    @BeforeEach
    public void setUp() {
        Brand brand = new Brand("Red Dragon");
        Department department = new Department("Hardware", "Hardware department");
        productDTO = new ProductDTO(1, "Teclado Mecânico", 600.00, brand
                , "Teclado com teclas suaves", department, 15);
        productService = new ProductService();
    }

    @Test
    public void addProductReturnsBoolean() {
        // GIven
        boolean expected = true;
        // When
        boolean actual = productService.addProduct(productDTO);
        // Then
        assertEquals(expected, actual);
    }
}
