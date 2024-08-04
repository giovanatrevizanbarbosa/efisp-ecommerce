package efisp.efispecommerce.models.entitys;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    //identifier
    private final User owner;
    //Map<ProductId, Item>
    private final Map<Integer, Item> items;
    private double totalPrice;

    public Cart(User owner) {
        this.owner = owner;
        items = new HashMap<>();
        totalPrice = 0;
    }

    public User getOwner() {
        return owner;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void insertItem(Item item) {
        items.put(item.getProduct().getId(), item);
        totalPrice += item.getProduct().getPrice() * item.getQuantity();
    }

    public Item removeItem(int productId) {
        Item item = items.remove(productId);
        totalPrice -= item.getProduct().getPrice() * item.getQuantity();

        return item;
    }
}