package efisp.efispecommerce.dto;

public class UserDTO {
    private final String email;
    private final String password;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
