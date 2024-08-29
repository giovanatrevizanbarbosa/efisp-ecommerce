package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.ProductDTO;
import efisp.efispecommerce.models.entitys.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductController {
    public ProductController controller;

    @BeforeEach
    public void Initialize() {
        controller = new ProductController();
    }

    @Test
    public void testAddProduct() {
        var brand = new Brand(1L, "Logitech");
        var department = new Department(1L, "Perifericos", "Periféricos gamers");

        var productDto = new ProductDTO(1L, "Mouse gamer", 1000.00, brand, "Mouse usado em competição", department, 10);

        var result = controller.addProduct(productDto);

        assertTrue(result);
    }
}
