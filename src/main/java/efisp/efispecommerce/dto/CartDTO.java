package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;

import java.util.Map;
import java.util.UUID;

/**
 * @param id Cart's id
 * @param ownerEmail Cart's owner email
 * @param items Cart's items
 */

// Map<ProductId, Item>
public record CartDTO(UUID id, String ownerEmail, Map<UUID, Item> items){
    public double totalPrice(){
        double total = 0;
        for (Item item : items.values()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public int totalItems(){
        int total = 0;
        for (Item item : items.values()) {
            total += item.getQuantity();
        }
        return total;
    }
}
