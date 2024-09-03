package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;

import java.util.UUID;

public class Rating extends Writable {
    //identifier
    private final String userEmail;
    //identifier
    private final UUID productId;
    private final String comment;
    private final int rating;

    public Rating(UUID id, String userEmail, UUID productId, String comment, int rating) {
        super(id);
        this.userEmail = userEmail;
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getOwnerEmail() {
        return userEmail;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public Csv toCSV() {
        return new Csv(new String[]{"id", "userEmail", "productId", "comment", "rating"}, new String[]{getId().toString(), userEmail, String.valueOf(productId), comment, String.valueOf(rating)});
    }
}