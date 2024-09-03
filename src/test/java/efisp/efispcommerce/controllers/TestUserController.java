package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserController {
    public UserController controller;

    @BeforeEach
    public void Initialize() {
        controller = new UserController();
    }

    @Test
    public void testAddUser() {
        var userDto = new UserDTO(UUID.randomUUID(), "Cauã", "test@gmail.com", "123456789", "photo");

        var result = controller.addUser(userDto);

        assertTrue(result);
    }
}
