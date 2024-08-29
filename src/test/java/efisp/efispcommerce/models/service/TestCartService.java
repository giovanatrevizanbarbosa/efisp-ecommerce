package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.entitys.Product;
import efisp.efispecommerce.models.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartService {
    private CartService cartService;
    private CartDTO cartDTO;
    private String ownerEmail;
    private Map<Long, Item> items;

    @BeforeEach
    public void setUp() {
        cartService = new CartService();
        ownerEmail = "gi.trevizan.barbosa@gmail.com";
        items = new HashMap<>();

        Brand brand = new Brand(1L,"Dell");
        Department department = new Department(1L,"Electronics", "Electronics department");

        Product product1 = new Product(1L, "Laptop", 1000.0, brand, "High-performance laptop", department, 5);
        Product product2 = new Product(2L, "Smartphone", 500.0, brand, "Latest smartphone", department, 10);

        items.put(1L, new Item(1L, 1L, product1, 2));
        items.put(2L, new Item(2L, 2L, product2, 1));

        cartDTO = new CartDTO(1L, ownerEmail, items);
    }

    @Test
    public void addCart() {
        // Given
        boolean expected = true;
        // When
        boolean actual = cartService.addCart(cartDTO);
        // Then
        assertEquals(expected, actual);
    }
}
