package efisp.efispcommerce.controllers;

import efisp.efispecommerce.controllers.UserController;
import efisp.efispecommerce.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserController {
    public UserController controller;

    @BeforeEach
    public void Initialize() {
        controller = new UserController();
    }

    @Test
    public void testAddUser() {
        var userDto = new UserDTO(UUID.randomUUID(), "Cauã", "test@gmail.com", "123456789");

        var result = controller.add(userDto);

        assertTrue(result);
    }

    @Test
    public void testAuthenticate() {
        var userDto = new UserDTO(UUID.randomUUID(), "Cauã", "causTeste@gmail.com", "123456789");

        controller.add(userDto);

        var result = controller.authenticate("causTeste@gmail.com", "123456789");

        assertNotNull(result);
    }

    @Test
    public void testUpdateUser() {
        var userDto = new UserDTO(UUID.randomUUID(), "Cauã", "caua@g.com", "123456789");

        controller.add(userDto);

        var newUserDto = new UserDTO(UUID.randomUUID(), "Cauã", "casdafsafa@a.com", "123456789");
        var result = controller.update(userDto.id(), newUserDto);

        assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        var userDto = new UserDTO(UUID.randomUUID(), "Cauã", "asdasd@gmail.com", "123456789");

        controller.add(userDto);

        var result = controller.delete("asdasd@gmail.com", "123456789");

        assertTrue(result);
    }
}
