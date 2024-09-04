package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cart extends Writable {
    private final String ownerEmail;
    //Map<ProductId, Item>
    private final Map<UUID, Item> items;
    private int itemsQuantity;
    private double totalPrice;

    public Cart(UUID id, String ownerEmail) {
        super(id);
        this.ownerEmail = ownerEmail;
        items = new HashMap<>();
        itemsQuantity = 0;
        totalPrice = 0;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public Map<UUID, Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Boolean insertItem(Item item) {
        if (items.put(item.getProduct().getId(), item) == null) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
            itemsQuantity += item.getQuantity();
            return true;
        }
        return false;
    }

    public Item removeItem(UUID productId) {
        Item item = items.remove(productId);
        totalPrice -= item.getProduct().getPrice() * item.getQuantity();
        itemsQuantity -= item.getQuantity();

        return item;
    }

    public int getItemsQuantity() { return itemsQuantity; }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (!(obj instanceof Cart cart)) return false;
        return ownerEmail.equals(cart.ownerEmail);
    }

    @Override
    public int hashCode() {
        return ownerEmail.hashCode();
    }

    @Override
    public Csv toCSV() {
        return new Csv(
                new String[]{"id", "ownerEmail", "totalPrice"},
                new String[]{getId().toString(), ownerEmail, String.valueOf(totalPrice)}
        );
    }
}