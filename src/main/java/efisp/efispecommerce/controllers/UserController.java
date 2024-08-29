package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.UserDTO;
import efisp.efispecommerce.models.service.UserService;

public class UserController {
    private UserService service;

    public UserController() {
        service = new UserService();
    }

    public boolean addUser(UserDTO userDto) {
        return service.addUser(userDto);
    }
}
