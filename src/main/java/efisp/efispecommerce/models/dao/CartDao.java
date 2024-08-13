package efisp.efispecommerce.models.dao;

import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Item;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CartDao implements Dao<Cart> {

    private static CartDao instance;
    private final Map<Long, Cart> carts;

    private CartDao() {
        carts = new HashMap<>();
    }

    public static Dao<Cart> getInstance() {
        if (instance == null) {
            instance = new CartDao();
        }
        return instance;
    }

    @Override
    public boolean add(Cart cart) {
        Cart cart1 = new Cart(cart.getOwnerEmail());
        for (Item item : cart.getItems().values()) {
            cart1.insertItem(new Item(item.getProduct(), item.getQuantity()));
        }

        return carts.put((long) carts.size(), cart1) == null;
    }

    @Override
    public boolean update(long id, Cart cart) {
        Cart cart1 = new Cart(cart.getOwnerEmail());
        for (Item item : cart.getItems().values()) {
            cart1.insertItem(new Item(item.getProduct(), item.getQuantity()));
        }

        return carts.replace(id, cart1) != null;
    }

    @Override
    public boolean delete(long id) {
        return carts.remove(id) != null;
    }

    @Override
    public Cart getById(long id) {
        Cart cartFinded = carts.get(id);

        if (cartFinded != null) {
            Cart cart1 = new Cart(cartFinded.getOwnerEmail());
            for (Item item : cartFinded.getItems().values()) {
                cart1.insertItem(new Item(item.getProduct(), item.getQuantity()));
            }

            return cart1;
        }

        throw new RuntimeException("Cart not found");
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> cartsList = new LinkedList<>();

        carts.values().forEach(cart -> {
            Cart cart1 = new Cart(cart.getOwnerEmail());
            for (Item item : cart.getItems().values()) {
                cart1.insertItem(new Item(item.getProduct(), item.getQuantity()));
            }
            cartsList.add(cart1);
        });

        return cartsList;
    }

}
