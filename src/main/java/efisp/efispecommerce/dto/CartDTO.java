package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;

import java.util.Map;

public class CartDTO {
    private final Long id;
    private final String ownerEmail;
    //Map<ProductId, Item>
    private final Map<Long, Item> items;
    private final double totalPrice;


    public CartDTO(Long id, String ownerEmail, Map<Long, Item> items) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.items = items;
        this.totalPrice = 0;
    }

    public Long getId() {
        return id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public Map<Long, Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
