package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.Order;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrder {
    User user;
    Cart cart;
    Address address;
    Order order;

    public void Initialize() {
        user = new User("Cauã", "caua@gmail.com", "Password123");
        cart = new Cart("caua@gmail.com");
        address = new Address("Rua Yoki", "700", "Araraquara", "SP", "14800200");
        order = new Order(user, cart, PaymentMethod.CreditCard, address);
    }

    @Test
    public void TestOrderGetUser() {
        Initialize();

        User expected = user;
        User actual = order.getUser();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderGetCart() {
        Initialize();

        Cart expected = cart;
        Cart actual = order.getCart();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetCart() {
        Initialize();

        Cart expected = new Cart("igor@gmail.com");
        order.setCart(expected);
        Cart actual = order.getCart();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetCartNotNull() {
        Initialize();

        order.setCart(null);
        Cart actual = order.getCart();

        assertNotNull(actual);
    }

    @Test
    public void TestOrderGetPaymentMethod() {
        Initialize();

        PaymentMethod expected = PaymentMethod.CreditCard;
        PaymentMethod actual = order.getPaymentMethod();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetPaymentMethod() {
        Initialize();

        PaymentMethod expected = PaymentMethod.FetLock;
        order.setPaymentMethod(expected);
        PaymentMethod actual = order.getPaymentMethod();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetPaymentMethodNotNull() {
        Initialize();

        order.setPaymentMethod(null);
        PaymentMethod actual = order.getPaymentMethod();

        assertNotNull(actual);
    }

    @Test
    public void TestOrderGetAddress() {
        Initialize();

        Address expected = address;
        Address actual = order.getAddress();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetAddress() {
        Initialize();

        Address expected = new Address("Rua Pipoca", "500", "Araraquara", "SP", "14800200");
        order.setAddress(expected);
        Address actual = order.getAddress();

        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderSetAddressNotNull() {
        Initialize();

        order.setAddress(null);
        Address actual = order.getAddress();

        assertNotNull(actual);
    }
}