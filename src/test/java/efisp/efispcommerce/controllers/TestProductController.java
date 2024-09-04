package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.ProductController;
import efisp.efispecommerce.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestProductController {
    public ProductController controller;

    @BeforeEach
    public void Initialize() {
        controller = new ProductController();
    }

    @Test
    public void testAddProduct() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        var result = controller.add(productDto);

        assertTrue(result);
    }

    @Test
    public void testUpdateProduct() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.update(productDto.id(), productDto);

        assertTrue(result);
    }

    @Test
    public void testDeleteProduct() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.delete(productDto.id());

        assertTrue(result);
    }

    @Test
    public void testGetProduct() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.get(productDto.id());

        assertNotNull(result);
    }

    @Test
    public void testGetAllProducts() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getAll();

        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductsByBrand() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getByBrand(productDto.brand());

        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductsByDepartment() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getByDepartment(productDto.department());

        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductsByPriceRange() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getByPriceRange(900.00, 1100.00);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductsByStock() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getByStock(5);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductsByName() {
        var productDto = new ProductDTO(UUID.randomUUID(), "Mouse gamer", 1000.00, "Samsung", "Mouse usado em competição", "Informática", 10, "photo");

        controller.add(productDto);

        var result = controller.getByName("Mouse");

        assertFalse(result.isEmpty());
    }

}
