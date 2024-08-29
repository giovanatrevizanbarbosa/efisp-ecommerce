package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.service.CartService;

public class CartController {
    private CartService service;

    public CartController() {
         service = new CartService();
    }

    public boolean addCart(CartDTO cartDto) {
        return service.addCart(cartDto);
    }
}
