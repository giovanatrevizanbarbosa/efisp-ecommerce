package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;

public class OrderDTO {
    private final Integer id;
    private final User user;
    private final Cart cart;
    private final PaymentMethod paymentMethod;
    private final Address address;

    public OrderDTO(Integer id, User user, Cart cart, PaymentMethod paymentMethod, Address address) {
        this.id = id;
        this.user = user;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.address = address;
    }

    public Integer getId() { return id; }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Address getAddress() {
        return address;
    }
}
