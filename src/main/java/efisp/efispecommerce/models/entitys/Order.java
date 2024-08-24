package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.enums.PaymentMethod;

public class Order implements Writable {
    private final int id;
    //identifier
    private final User user;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private Address address;

    public Order(int id, User user, Cart cart, PaymentMethod method, Address address) {
        this.id = id;
        this.user = user;
        this.cart = cart;
        this.paymentMethod = method;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        if (cart != null)
            this.cart = cart;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod != null)
            this.paymentMethod = paymentMethod;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null)
            this.address = address;
    }

    @Override
    public String[] toCSV() {
        return new String[]{ String.valueOf(id), String.valueOf(user.getId()), String.valueOf(cart.getId()), paymentMethod.name(), address.getZip() + address.getNumber() };
    }
}