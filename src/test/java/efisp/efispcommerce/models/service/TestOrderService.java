package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.OrderDTO;
import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;
import efisp.efispecommerce.models.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderService {
    private OrderService orderService;
    private OrderDTO orderDTO;
    @BeforeEach
    public void setUp() {
        orderDTO = new OrderDTO(UUID.randomUUID(),
                new User(UUID.randomUUID(), "Giovana Trevizan", "gi.trevizan.barbosa@gmail.com", "123456"),
                new Cart(UUID.randomUUID(), "gi.treviza.barbosa@gmail.com"), PaymentMethod.Pix,
                new Address(UUID.randomUUID(),"Rua 1", 120, "Araraquara", "São Paulo", "14800737"));

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
