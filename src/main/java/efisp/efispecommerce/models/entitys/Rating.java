package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

public class Rating extends Writable {
    //identifier
    private final String userEmail;
    //identifier
    private final int productId;
    private final String comment;
    private final int rating;

    public Rating(String userEmail, int productId, String comment, int rating) {
        this.userEmail = userEmail;
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getOwnerEmail() {
        return userEmail;
    }

    public int getProductId() {
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