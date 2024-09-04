package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserService {
    private UserDTO userDTO;
    private UserService userService;
    @BeforeEach
    public void setUp() {
        userDTO = new UserDTO(UUID.randomUUID(), "Giovana Trevizan", "gi.trevizfan.barbosa@gmail.com", "123456");
        userService = new UserService();
    }

    @Test
    public void TestEqualsUser(){
        UserDTO userDTO2 = userService.getUserByEmail("giovaninha@gmail.com");

        if (userDTO2 == null) {
            UserDTO userDTO = new UserDTO(UUID.randomUUID(), "Giovana Trevizan", "giovaninha@gmail.com", "123456");
            assertTrue(userService.addUser(userDTO));
        }

        assertFalse(userService.addUser(userDTO));
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
