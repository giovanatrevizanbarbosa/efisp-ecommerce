package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderDTO {

    private OrderDTO orderDTO;
    private User user;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private Address address;

    @BeforeEach
    public void setUp() {
        user = new User("Giovana", "gi.trevizan.barbosa@gmail.com", "senha1234");
        cart = new Cart("gi.trevizan.barbosa@gmail.com");
        paymentMethod = PaymentMethod.CreditCard;
        address = new Address("123 Main St", "Springfield", "IL", "62701", "USA");

        orderDTO = new OrderDTO(user, cart, paymentMethod, address);
    }

    @Test
    public void getUserReturnsCorrectUser() {
        // Given
        User expectedUser = user;
        // When
        User actualUser = orderDTO.getUser();
        // Then
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getCartReturnsCorrectCart() {
        // Given
        Cart expectedCart = cart;
        // When
        Cart actualCart = orderDTO.getCart();
        // Then
        assertEquals(expectedCart, actualCart);
    }

    @Test
    public void getPaymentMethodReturnsCorrectPaymentMethod() {
        // Given
        PaymentMethod expectedPaymentMethod = paymentMethod;
        // When
        PaymentMethod actualPaymentMethod = orderDTO.getPaymentMethod();
        // Then
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void getAddressReturnsCorrectAddress() {
        // Given
        Address expectedAddress = address;
        // When
        Address actualAddress = orderDTO.getAddress();
        // Then
        assertEquals(expectedAddress, actualAddress);
    }
}