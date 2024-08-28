package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.User;

public class UserDTO {
    private long id;
    private String name;
    private final String email;
    private final String password;

    public UserDTO(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
