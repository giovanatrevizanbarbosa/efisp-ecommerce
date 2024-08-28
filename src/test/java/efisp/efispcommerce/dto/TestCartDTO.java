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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartDTO {

    private CartDTO cartDTO;
    private String ownerEmail;
    private Map<Long, Item> items;

    @BeforeEach
    public void setUp() {
        ownerEmail = "gi.trevizan.barbosa@gmail.com";
        items = new HashMap<>();

        Brand brand = new Brand(1L, "Dell");
        Department department = new Department(3L, "Electronics", "Electronics department");

        Product product1 = new Product(1L, "Laptop", 1000.0, brand, "High-performance laptop", department, 5);
        Product product2 = new Product(2L, "Smartphone", 500.0, brand, "Latest smartphone", department, 10);

        items.put(1L, new Item(1L, product1, 2));
        items.put(2L, new Item(2L, product2, 1));

        cartDTO = new CartDTO(1L, ownerEmail, items);
    }

    @Test
    public void getOwnerEmailReturnsCorrectEmail() {
        // Given
        String expectedEmail = ownerEmail;
        // When
        String actualEmail = cartDTO.getOwnerEmail();
        // Then
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void getItemsReturnsCorrectItems() {
        // Given
        Map<Long, Item> expectedItems = items;
        // When
        Map<Long, Item> actualItems = cartDTO.getItems();
        // Then
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void getTotalPriceReturnsDefaultPrice() {
        // Given
        double expectedPrice = 0.0;
        // When
        double actualPrice = cartDTO.getTotalPrice();
        // Then
        assertEquals(expectedPrice, actualPrice);
    }
}