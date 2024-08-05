package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.enums.PaymentMethod;

public class Order {
    //identifier
    private final User user;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private Address address;

    public Order(User user, Cart cart, PaymentMethod method, Address address) {
        this.user = user;
        this.cart = cart;
        this.paymentMethod = method;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}