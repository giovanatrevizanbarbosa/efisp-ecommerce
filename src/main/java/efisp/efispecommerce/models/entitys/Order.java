package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;
import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.UUID;

public class Order extends Writable {
    //identifier
    private final User user;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private Address address;

    public Order(UUID id, User user, Cart cart, PaymentMethod method, Address address) {
        super(id);
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
    public Csv toCSV() {
        return new Csv(
                new String[]{"id", "userEmail", "cartId", "paymentMethod", "addressId"},
                new String[]{getId().toString(), user.getEmail(), String.valueOf(cart.getId()), paymentMethod.toString(), address.getId().toString()}
        );
    }
}