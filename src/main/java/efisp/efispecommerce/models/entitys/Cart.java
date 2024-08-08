package efisp.efispecommerce.models.entitys;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final int id;
    //identifier
    private final String ownerEmail;
    //Map<ProductId, Item>
    private final Map<Integer, Item> items;
    private double totalPrice;

    public Cart(int id, String ownerEmail) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        items = new HashMap<>();
        totalPrice = 0;
    }

    public int getId() {
        return id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Boolean insertItem(Item item) {
        if (items.put(item.getProduct().getId(), item) == null){
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
            return true;
        }
        return false;
    }

    public Item removeItem(int productId) {
        Item item = items.remove(productId);
        totalPrice -= item.getProduct().getPrice() * item.getQuantity();

        return item;
    }
}