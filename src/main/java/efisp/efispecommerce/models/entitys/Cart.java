package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

import java.util.HashMap;
import java.util.Map;

public class Cart extends Writable {
    //identifier
    private final String ownerEmail;
    //Map<ProductId, Item>
    private final Map<Integer, Item> items;
    private double totalPrice;

    public Cart(Long id, String ownerEmail) {
        super(id);
        this.ownerEmail = ownerEmail;
        items = new HashMap<>();
        totalPrice = 0;
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
        if (items.put(Integer.parseInt(item.getProduct().getId().toString()), item) == null){
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

    @Override
    public Csv toCSV() {
        return new Csv(
                new String[]{"id", "ownerEmail", "totalPrice"},
                new String[]{getId().toString(), ownerEmail, String.valueOf(totalPrice)}
        );
    }
}