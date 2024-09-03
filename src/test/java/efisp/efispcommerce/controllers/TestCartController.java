package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.entitys.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCartController {
    CartController controller;

    @BeforeEach
    public void Initialize() {
         controller = new CartController();
    }

    @Test
    public void testAddCart() {
        var items = new HashMap<UUID, Item>();

        CartDTO cartDto = new CartDTO(UUID.randomUUID(), "tester@email.com", items, 100.00);

        var result = controller.addCart(cartDto);

        assertTrue(result);
    }
}
