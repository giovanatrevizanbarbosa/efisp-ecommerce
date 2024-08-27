package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;
import efisp.efispecommerce.models.enums.PaymentMethod;

public class Order extends Writable {
    //identifier
    private final User user;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private Address address;

    public Order(int id, User user, Cart cart, PaymentMethod method, Address address) {
        setId((long) id);
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