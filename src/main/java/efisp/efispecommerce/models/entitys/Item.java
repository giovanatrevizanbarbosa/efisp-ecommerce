package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

public class Item extends Writable {
    //identifier
    private final Product product;
    private int quantity;

    public Item(Long id, Product product, int quantity) {
        super(id);
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

    @Override
    public Csv toCSV() {
        return new Csv(
                new String[]{"id", "productId", "quantity"},
                new String[]{getId().toString(), product.getId().toString(), String.valueOf(quantity)}
        );
    }
}