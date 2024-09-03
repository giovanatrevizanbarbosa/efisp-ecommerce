package efisp.efispcommerce.controllers;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.dto.CartDTO;
import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.enums.PaymentMethod;
import efisp.efispecommerce.controllers.OrderController;
import efisp.efispecommerce.models.service.AddressService;
import efisp.efispecommerce.models.service.CartService;
import efisp.efispecommerce.models.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderController {
    public OrderController controller;

    @BeforeEach
    public void Initialize() {
        controller = new OrderController();
    }

    @Test
    public void testAddOrder() {

        UserService userService = new UserService();
        CartService cartService = new CartService();
        AddressService addressDao = new AddressService();

        var user = new UserDTO(UUID.randomUUID(), "Cauã", "a.com", "123", "photo");
        userService.addUser(user);

        var cart = new CartDTO(UUID.randomUUID(), "a.com", new HashMap<>());
        cartService.addCart(cart);

        var address = new AddressDTO(UUID.randomUUID(), "Rua", "123", "Cidaede", "Estado", "12345-123");
        addressDao.add(address);

        OrderDTO orderDto = new OrderDTO(UUID.randomUUID(), user, cart, PaymentMethod.CreditCard, address);

        var result = controller.addOrder(orderDto);

        assertTrue(result);
    }
}
