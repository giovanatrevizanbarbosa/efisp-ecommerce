package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrder {
    User user;
    Cart cart;
    Address address;
    Order order;

    @BeforeEach
    public void Initialize() {
        user = new User(UUID.randomUUID(), "Cauã", "caua@gmail.com", "Password123");
        cart = new Cart(UUID.randomUUID(), "caua@gmail.com");
        address = new Address(UUID.randomUUID(), "Rua Yoki", "700", "Araraquara", "SP", "14800200");
        order = new Order(UUID.randomUUID(), user, cart, PaymentMethod.CreditCard, address);
    }

    @Test
    public void TestOrderGetUser() {
        User expected = user;
        User actual = order.getUser();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderGetCart() {
        Cart expected = cart;
        Cart actual = order.getCart();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetCart() {
        Cart expected = new Cart(UUID.randomUUID(), "igor@gmail.com");
        order.setCart(expected);
        Cart actual = order.getCart();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetCartNotNull() {
        order.setCart(null);
        Cart actual = order.getCart();

        assertNotNull(actual);
    }

    @Test
    public void TestOrderGetPaymentMethod() {
        PaymentMethod expected = PaymentMethod.CreditCard;
        PaymentMethod actual = order.getPaymentMethod();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetPaymentMethod() {
        PaymentMethod expected = PaymentMethod.FetLock;
        order.setPaymentMethod(expected);
        PaymentMethod actual = order.getPaymentMethod();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetPaymentMethodNotNull() {
        order.setPaymentMethod(null);
        PaymentMethod actual = order.getPaymentMethod();

        assertNotNull(actual);
    }

    @Test
    public void TestOrderGetAddress() {
        Address expected = address;
        Address actual = order.getAddress();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetAddress() {
        Address expected = new Address(UUID.randomUUID(),"Rua Pipoca", "500", "Araraquara", "SP", "14800200");
        order.setAddress(expected);
        Address actual = order.getAddress();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetAddressNotNull() {
        order.setAddress(null);
        Address actual = order.getAddress();

        assertNotNull(actual);
    }
}