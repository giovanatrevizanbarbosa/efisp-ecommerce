package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.CartController;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.entitys.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestCartController {
    CartController controller;
    CartDTO cartDto;

    @BeforeEach
    public void Initialize() {
        var items = new HashMap<UUID, Item>();
        cartDto = new CartDTO(UUID.randomUUID(), "gi.trevizan.barbosa@gmail.com", items);
        controller = new CartController();
        controller.addCart(cartDto);
    }

    @Test
    public void testAddCart() {
        var items = new HashMap<UUID, Item>();

        CartDTO cartDto = new CartDTO(UUID.randomUUID(), "tester@email.com", items);

        var result = controller.addCart(cartDto);

        assertTrue(result);
    }

    @Test
    public void testGetCartByOwnerEmail(){
        var result = controller.getCartByOwnerEmail("gi.trevizan.barbosa@gmail.com");
        assertEquals(cartDto, result);
    }
}