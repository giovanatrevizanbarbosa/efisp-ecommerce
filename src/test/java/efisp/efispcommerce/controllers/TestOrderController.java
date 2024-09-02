package efisp.efispcommerce.controllers;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import efisp.efispecommerce.controllers.OrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderController {
    public OrderController controller;

    @BeforeEach
    public void Initialize() {
        controller = new OrderController();
    }

    @Test
    public void testAddOrder() {
        var user = new User(1L, "Cauã", "test@gmail.com", "123456789");
        var cart = new Cart(1L, "test@gmail.com");
        var address = new Address(1L, "rua 1", 123, "Araraquara", "SP", "14800200");

        OrderDTO orderDto = new OrderDTO(1L, user, cart, PaymentMethod.CreditCard, address);

        var result = controller.addOrder(orderDto);

        assertTrue(result);
    }
}
