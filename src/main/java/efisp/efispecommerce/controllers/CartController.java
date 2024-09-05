package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.models.service.CartService;

import java.util.List;
import java.util.UUID;

public class CartController {
    private final CartService service;

    public CartController() {
         service = new CartService();
    }

    public boolean addCart(CartDTO cartDto) {
        return service.addCart(cartDto);
    }

    public boolean addItemToCart(ItemDTO itemDto) {

        return service.addItemToCart(itemDto);
    }

    public boolean removeItemFromCart(ItemDTO itemDto) {
        return service.removeItemFromCart(itemDto.id());
    }

    public boolean updateCart(UUID id, CartDTO cartDto) {
        return service.updateCart(id, cartDto);
    }

    public boolean deleteCart(UUID id) {
        return service.deleteCart(id);
    }

    public CartDTO getCartById(UUID id) {
        return service.getCartById(id);
    }

    public CartDTO getCartByOwnerEmail(String ownerEmail) {
        return service.getCartByOwnerEmail(ownerEmail);
    }

    public List<CartDTO> getAll() {
        return service.getAll();
    }


}
