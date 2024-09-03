package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserDTO {
    private final UserDTO userDTO = new UserDTO(1L, "Giovana Trevizan", "gi.trevizan.barbosa@gmail.com", "senha1234");
    @Test
    public void getUserDTOEmailReturnsCorrectEmail() {
        String expected = "gi.trevizan.barbosa@gmail.com";
        String actual = userDTO.email();

        assertEquals(expected, actual);
    }

    @Test
    public void getUserDTOPasswordReturnsCorrectPassword() {
        String expected = "senha1234";
        String actual = userDTO.password();

        assertEquals(expected, actual);
    }
}