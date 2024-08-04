package efisp.efispecommerce.models.entitys;

public class Rating {
    private final User owner;
    private final int productId;
    private final String comment;
    private final int rating;

    public Rating(User owner, int productId, String comment, int rating) {
        this.owner = owner;
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public User getOwner() {
        return owner;
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
}