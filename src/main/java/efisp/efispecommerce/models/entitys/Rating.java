package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;

public class Rating implements Writable {
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
    public String[] toCSV() {
        return new String[]{ userEmail, String.valueOf(productId), comment, String.valueOf(rating)};
    }
}