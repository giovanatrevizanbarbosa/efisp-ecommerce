package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.entitys.Product;
import efisp.efispecommerce.models.service.CartService;
import efisp.efispecommerce.models.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartService {
    private CartService cartService;
    private CartDTO cartDTO;

    @BeforeEach
    public void setUp() {
        UserService userService = new UserService();

        cartService = new CartService();
        String ownerEmail = "gi.trevizan.barbosaa@gmail.com";
        userService.addUser(new UserDTO(UUID.randomUUID(), "Gi", ownerEmail, "123"));
        Map<UUID, Item> items = new HashMap<>();

        Brand brand = new Brand(UUID.randomUUID(),"Dell");
        Department department = new Department(UUID.randomUUID(),"Electronics", "Electronics department");

        Product product1 = new Product(UUID.randomUUID(), "Laptop", 1000.0, brand, "High-performance laptop", department, 5, "photo");
        Product product2 = new Product(UUID.randomUUID(), "Smartphone", 500.0, brand, "Latest smartphone", department, 10, "photo");

        UUID cartId = UUID.randomUUID();

        items.put(product1.getId(), new Item(UUID.randomUUID(), cartId, product1, 2));
        items.put(product2.getId(), new Item(UUID.randomUUID(), cartId, product2, 1));

        cartDTO = new CartDTO(cartId, ownerEmail, items);
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
