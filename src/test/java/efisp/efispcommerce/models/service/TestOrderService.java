package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.service.AddressService;
import efisp.efispecommerce.models.service.CartService;
import efisp.efispecommerce.models.service.OrderService;
import efisp.efispecommerce.models.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static efisp.efispecommerce.models.enums.PaymentMethod.Pix;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderService {
    private OrderService orderService;
    private OrderDTO orderDTO;
    @BeforeEach
    public void setUp() {

        UserService userDAO = new UserService();
        CartService cartDAO = new CartService();
        AddressService addressDAO = new AddressService();

        var user = new UserDTO(UUID.randomUUID(), "Giovana Trevizan", "gi.trevizan.barbosa@gmail.com", "123456", "photo");
        var cart = new CartDTO(UUID.randomUUID(), "gi.treviza.barbosa@gmail.com", new HashMap<>());
        var address = new AddressDTO(UUID.randomUUID(),"Rua 1", "120", "Araraquara", "São Paulo", "14800737");


        userDAO.addUser(user);
        cartDAO.addCart(cart);
        addressDAO.add(address);

        orderDTO = new OrderDTO(UUID.randomUUID(), user, cart, Pix, address);

        orderService = new OrderService();
    }

    @Test
    public void addOrderReturnsBoolean() {
        // Given
        boolean expected = true;
        // When
        boolean actual = orderService.addOrder(orderDTO);
        // Then
        assertEquals(expected, actual);
    }
}
