package efisp.efispcommerce.dto;

import efisp.efispecommerce.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserDTO {
    private final UserDTO userDTO = new UserDTO("gi.trevizan.barbosa@gmail.com", "senha1234");
    @Test
    public void testGivenGetEmailWhenGiovanaThenGiovana() {
        String expected = "gi.trevizan.barbosa@gmail.com";
        String actual = userDTO.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    public void testGivenGetPasswordWhenSenha1234ThenSenha1234() {
        String expected = "senha1234";
        String actual = userDTO.getPassword();

        assertEquals(expected, actual);
    }
}
