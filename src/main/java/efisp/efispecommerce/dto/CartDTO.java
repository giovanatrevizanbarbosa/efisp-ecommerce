package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;

import java.util.Map;

public class CartDTO {
    private final int id;
    private final String ownerEmail;
    //Map<ProductId, Item>
    private final Map<Integer, Item> items;
    private final double totalPrice;


    public CartDTO(Integer id, String ownerEmail, Map<Integer, Item> items) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.items = items;
        this.totalPrice = 0;
    }

    public Integer getId() {
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
}
