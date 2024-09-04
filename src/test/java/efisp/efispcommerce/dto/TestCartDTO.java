package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.entitys.Brand;
import efisp.efispecommerce.models.entitys.Department;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.entitys.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartDTO {

    private CartDTO cartDTO;
    private String ownerEmail;
    private Map<UUID, Item> items;

    @BeforeEach
    public void setUp() {
        ownerEmail = "gi.trevizan.barbosa@gmail.com";
        items = new HashMap<>();

        Brand brand = new Brand(UUID.randomUUID(), "Dell");
        Department department = new Department(UUID.randomUUID(), "Electronics", "Electronics department");


        UUID productId = UUID.randomUUID();
        UUID cartId = UUID.randomUUID();

        Product product = new Product(productId, "Mouse gamer", 1000.00, brand, "Mouse usado em competição", department, 10, "photo");

        items.put(UUID.randomUUID(), new Item(UUID.randomUUID(), cartId, product, 2));
        items.put(UUID.randomUUID(), new Item(UUID.randomUUID(), cartId, product, 1));

        cartDTO = new CartDTO(cartId, ownerEmail, items);
    }

    @Test
    public void getOwnerEmailReturnsCorrectEmail() {
        // Given
        String expectedEmail = ownerEmail;
        // When
        String actualEmail = cartDTO.ownerEmail();
        // Then
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void getItemsReturnsCorrectItems() {
        // Given
        Map<UUID, Item> expectedItems = items;
        // When
        Map<UUID, Item> actualItems = cartDTO.items();
        // Then
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void getTotalPriceReturnsDefaultPrice() {
        // Given
        double expectedPrice = 3000.00;
        // When
        double actualPrice = cartDTO.totalPrice();
        // Then
        assertEquals(expectedPrice, actualPrice);
    }
}