package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.models.entitys.Cart;

import java.util.LinkedList;
import java.util.List;

public class CartService {
    private final List<Cart> products = new LinkedList<>();

    private Cart mapCartDTOToEntity(CartDTO cartDTO){
        return new Cart(cartDTO.getId(), cartDTO.getOwnerEmail());
    }

    public boolean addCart(CartDTO cartDTO) {
        return products.add(mapCartDTOToEntity(cartDTO));
    }
}
