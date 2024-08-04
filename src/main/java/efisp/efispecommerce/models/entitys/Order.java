package efisp.efispecommerce.models.entitys;

public class Order {
    //identifier
    private final User user;
    private Cart cart;
    private Address address;

    public Order(User user, Cart cart, Address address) {
        this.user = user;
        this.cart = cart;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}