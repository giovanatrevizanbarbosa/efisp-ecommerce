package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.dao.Writable;
import efisp.efispecommerce.models.dao.csv.Csv;
import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.List;
import java.util.UUID;

public class Order extends Writable {
    //identifier
    private final User user;
    private List<Item> items;
    private PaymentMethod paymentMethod;
    private Address address;

    public Order(UUID id, User user, List<Item> items, PaymentMethod method, Address address) {
        super(id);
        this.user = user;
        this.items = items;
        this.paymentMethod = method;
        this.address = address;
    }


    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        if (items != null)
            this.items = items;
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
                new String[]{"id", "userEmail", "paymentMethod", "addressId"},
                new String[]{getId().toString(), user.getEmail(), paymentMethod.toString(), address.getId().toString()}
        );
    }
}