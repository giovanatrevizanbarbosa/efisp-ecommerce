package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Cart;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CartService {
    private final IDao<Cart> dao = Dao.getInstance(Cart.class);
    private final ItemService itemService = new ItemService();

    Cart toEntity(CartDTO cartDTO){
        return new Cart(cartDTO.id(), cartDTO.ownerEmail());
    }

    CartDTO toDTO(Cart cart){
        return new CartDTO(cart.getId(), cart.getOwnerEmail(), cart.getItems());
    }

    public boolean addCart(CartDTO cartDTO) {
        return dao.add(toEntity(cartDTO));
    }

    public List<CartDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }

    public CartDTO getCartById(UUID id) {
        return toDTO(dao.getById(id));
    }

    public boolean updateCart(UUID id, CartDTO cartDTO) {
        return dao.update(id, toEntity(cartDTO));
    }

    public boolean deleteCart(UUID id) {
        return dao.delete(id);
    }

    public CartDTO getCartByOwnerEmail(String ownerEmail) {
        for (Cart cart : dao.getAll()) {
            if (Objects.equals(cart.getOwnerEmail(), ownerEmail)) {
                return toDTO(cart);
            }
        }

        return null;
    }

    public boolean addItemToCart(UUID id, ItemDTO itemDTO) {
        Cart cart = dao.getById(id);
        itemService.addItem(itemDTO);
        cart.insertItem(itemService.toEntity(itemDTO));
        return dao.update(id, cart);
    }

    public boolean removeItemFromCart(UUID id, UUID itemId) {
        Cart cart = dao.getById(id);
        itemService.deleteItem(itemId);
        cart.removeItem(itemId);
        return dao.update(id, cart);
    }
}
