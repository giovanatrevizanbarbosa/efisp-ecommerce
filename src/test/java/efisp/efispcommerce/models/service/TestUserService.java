package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserService {
    private UserDTO userDTO;
    private UserService userService;
    @BeforeEach
    public void setUp() {
        userDTO = new UserDTO(1L, "Giovana Trevizan", "gi.trevizan.barbosa@gmail.com", "123456");
        userService = new UserService();
    }

    @Test
    public void addUserReturnsBoolean() {
        // GIven
        boolean expected = true;
        // When
        boolean actual = userService.addUser(userDTO);
        // Then
        assertEquals(expected, actual);
    }
}
