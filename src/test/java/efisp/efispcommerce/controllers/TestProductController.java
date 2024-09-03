package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProductController {
    public ProductController controller;

    @BeforeEach
    public void Initialize() {
        controller = new ProductController();
    }

    @Test
    public void testAddProduct() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10);

        var result = controller.addProduct(productDto);

        assertTrue(result);
    }
}
