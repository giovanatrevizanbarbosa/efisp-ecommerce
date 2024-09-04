package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.service.UserService;

import java.util.UUID;

public class UserController {
    private final UserService service;

    public UserController() {
        service = new UserService();
    }

    public boolean add(UserDTO userDto) {
        return service.addUser(userDto);
    }

    public UserDTO authenticate(String email, String password) {
        return service.authenticate(email, password);
    }

    public boolean update(UUID id, UserDTO newUser) {
        return service.updateUser(id, newUser);
    }

    public boolean delete(String email, String password) {
        UserDTO user = authenticate(email, password);
        if (user != null) {
            return service.deleteUser(user.id());
        }

        return false;
    }


}
