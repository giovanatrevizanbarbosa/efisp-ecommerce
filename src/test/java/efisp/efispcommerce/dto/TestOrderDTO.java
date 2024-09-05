package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.enums.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderDTO {

    private OrderDTO orderDTO;
    private UserDTO user;
    private List<Item> items;
    private PaymentMethod paymentMethod;
    private AddressDTO address;

    @BeforeEach
    public void setUp() {
        user = new UserDTO(UUID.randomUUID(), "Giovana", "gi.trevizan.barbosa@gmail.com", "senha1234");
        items = new LinkedList<>();

        paymentMethod = PaymentMethod.CreditCard;
        address = new AddressDTO(UUID.randomUUID(),"123 Main St", "10A", "Springfield", "62701", "USA");


        orderDTO = new OrderDTO(UUID.randomUUID(), user, items, paymentMethod, address);
    }

    @Test
    public void getUserReturnsCorrectUser() {
        // Given
        UserDTO expectedUser = user;
        // When
        UserDTO actualUser = orderDTO.user();
        // Then
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getCartReturnsCorrectCart() {
        // Given
        List<Item> items = new LinkedList<>();
        // When
        List<Item> actualCart = orderDTO.items();
        // Then
        assertEquals(items, actualCart);
    }

    @Test
    public void getPaymentMethodReturnsCorrectPaymentMethod() {
        // Given
        PaymentMethod expectedPaymentMethod = paymentMethod;
        // When
        PaymentMethod actualPaymentMethod = orderDTO.paymentMethod();
        // Then
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void getAddressReturnsCorrectAddress() {
        // Given
        var expectedAddress = address;
        // When
        var actualAddress = orderDTO.address();
        // Then
        assertEquals(expectedAddress, actualAddress);
    }
}