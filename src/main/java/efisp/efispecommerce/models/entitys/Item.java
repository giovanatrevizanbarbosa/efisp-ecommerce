package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

public class Item extends Writable {
    //identifier
    private final Product product;
    private final UUID cartId;
    private int quantity;

    public Item(UUID id, UUID cartId, Product product, int quantity) {
        super(id);
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
    }

    public UUID getCartId() {
        return cartId;
    }

    @Override
    public Csv toCSV() {
        return new Csv(
                new String[]{"id", "cardId" ,"productId", "quantity"},
                new String[]{getId().toString(), cartId.toString(), product.getId().toString(), String.valueOf(quantity)}
        );
    }
}